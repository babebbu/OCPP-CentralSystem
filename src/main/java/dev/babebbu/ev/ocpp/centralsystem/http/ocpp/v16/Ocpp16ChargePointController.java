package dev.babebbu.ev.ocpp.centralsystem.http.ocpp.v16;

import dev.babebbu.ev.ocpp.centralsystem.models.entities.ChargePoint;
import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.*;
import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits.*;
import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.IdTagInfo;
import dev.babebbu.ev.ocpp.centralsystem.services.ChargePointService;
import dev.babebbu.ev.ocpp.centralsystem.utils.DateFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.time.Instant;
import java.util.Date;

/**
 * <h1>4. Operations Initiated by Charge Point</h1>
 * <p>This class includes methods which are handling data internally submitted from websocket endpoint.</p>
 * <p></p>
 * <h2>TL;DR</h2>
 * <p>
 *     The descriptions above the method header are from "ocpp-1.6 edition 2.pdf" documentation file.
 *     They describes the situation how the charge point works. No need to read all of them.
 * </p>
 * <p></p>
 * @author Natthasak Vechprasit
 */
@RestController
@RequestMapping("/ocpp/v1.6/ChargePoints")
public class Ocpp16ChargePointController {

    /**
     * Logger (SLF4J)
     */
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    /**
     * Constant: Heartbeat Interval
     */
    private static final int HEARTBEAT_INTERVAL = 1440;

    /**
     * Dependency: {@link ChargePointService}
     */
    private final ChargePointService chargePointService;

    /**
     * Constructor (Dependency Injection)
     * @param chargePointService {@link ChargePointService}
     */
    public Ocpp16ChargePointController(ChargePointService chargePointService) {
        this.chargePointService = chargePointService;
    }

    /**
     * <h1>4.1. Authorize</h1>
     * <p>
     * Before the owner of an electric vehicle can start or stop charging, the Charge Point has to authorize the operation.
     * The Charge Point SHALL only supply energy after authorization. When stopping a Transaction,
     * the Charge Point SHALL only send an {@link AuthorizeRequest} when the identifier used for stopping the transaction is different from the identifier that started the transaction.
     * <p>
     * {@link AuthorizeRequest} SHOULD only be used for the authorization of an identifier for charging.
     * <p>
     * A Charge Point MAY authorize identifier locally without involving the Central System,
     * as described in Local Authorization List.
     * If an idTag presented by the user is not present in the Local Authorization List or Authorization Cache,
     * then the Charge Point SHALL send an {@link AuthorizeRequest} PDU to the Central System to request authorization.
     * If the idTag is present in the Local Authorization List or Authorization Cache,
     * then the Charge Point MAY send an {@link AuthorizeRequest} PDU to the Central System.
     * <p>
     * Upon receipt of an {@link AuthorizeRequest} PDU, the Central System SHALL respond with an {@link AuthorizeConfirm} PDU.
     * This response PDU SHALL indicate whether or not the idTag is accepted by the Central System.
     * If the Central System accepts the idTag then the response PDU MAY include a parentIdTag and MUST include
     * an authorization status value indicating acceptance or a reason for rejection.
     * <p>
     * If Charge Point has implemented an Authorization Cache,
     * then upon receipt of an {@link AuthorizeConfirm} PDU the Charge Point SHALL update the cache entry,
     * if the idTag is not in the Local Authorization List,
     * with the IdTagInfo value from the response as described under Authorization Cache.
     *
     * @param request {@link AuthorizeRequest}
     * @return {@link AuthorizeConfirm}
     */
    @PostMapping("/Authorize")
    public AuthorizeConfirm handleAuthorizeRequest(@RequestBody AuthorizeRequest request) {
        final int HOUR_IN_SECOND = 60 * 60;
        return AuthorizeConfirm
            .builder()
            .idTagInfo(IdTagInfo
                .builder()
                .expiryDate(DateFormatter.parseISO8601(Date.from(Instant.now().plusSeconds(HOUR_IN_SECOND))))
                .status(AuthorizationStatus.ACCEPTED)
                .build())
            .build();
    }

    /**
     * <h1>4.2. Boot Notification</h1>
     * <p>
     * After start-up, a Charge Point SHALL send a request to the Central System with information about its configuration
     * (e.g. version, vendor, etc.). The Central System SHALL respond to indicate whether it will accept the Charge Point.
     * <p>
     * The Charge Point SHALL send a {@link BootNotificationRequest} PDU each time it boots or reboots.
     * Between the physical power-on/reboot and the successful completion of a BootNotification,
     * where Central System returns Accepted or Pending,
     * the Charge Point SHALL NOT send any other request to the Central System.
     * This includes cached messages that are still present in the Charge Point from before.
     * <p>
     * When the Central System responds with a {@link BootNotificationConfirm} with a status Accepted,
     * the Charge Point will adjust the heartbeat interval in accordance with the interval from the response PDU and
     * it is RECOMMENDED to synchronize its internal clock with the supplied Central System’s current time.
     * If the Central System returns something other than Accepted,
     * the value of the interval field indicates the minimum wait time before sending a next BootNotification request.
     * If that interval value is zero, the Charge Point chooses a waiting interval on its own,
     * in a way that avoids flooding the Central System with requests.
     * A Charge Point SHOULD NOT send a {@link BootNotificationRequest} earlier, unless requested to do so with a {@link TriggerMessageRequest}.
     * <p>
     * If the Central System returns the status Rejected,
     * the Charge Point SHALL NOT send any OCPP message to the Central System until the aforementioned retry interval has expired.
     * During this interval the Charge Point may no longer be reachable from the Central System.
     * It MAY for instance close its communication channel or shut down its communication hardware.
     * Also the Central System MAY close the communication channel, for instance to free up system resources.
     * While Rejected, the Charge Point SHALL NOT respond to any Central System initiated message.
     * the Central System SHOULD NOT initiate any.
     * <p>
     * The Central System MAY also return a Pending registration status to indicate that it wants to retrieve or
     * set certain information on the Charge Point before the Central System will accept the Charge Point.
     * If the Central System returns the Pending status, the communication channel SHOULD NOT be closed by either
     * the Charge Point or the Central System.
     * The Central System MAY send request messages to retrieve information from the Charge Point or change its configuration.
     * The Charge Point SHOULD respond to these messages.
     * The Charge Point SHALL NOT send request messages to the Central System unless it has been instructed by
     * the Central System to do so with a {@link TriggerMessageRequest} request.
     * While in pending state, the following Central System initiated messages are not allowed:
     * {@link RemoteStartTransactionRequest} and {@link RemoteStopTransactionRequest}
     * <p>
     * <h3>4.2.1. Transactions before being accepted by a Central System</h3>
     * A Charge Point Operator MAY choose to configure a Charge Point to accept transactions before the Charge Point is
     * accepted by a Central System. Parties who want to implement this such behavior should realize that it is
     * uncertain if those transactions can ever be delivered to the Central System.
     * <p>
     * After a restart (for instance due to a remote reset command, power outage, firmware update, software error etc.)
     * the Charge Point MUST again contact the Central System and SHALL send a BootNotification request.
     * If the Charge Point fails to receive a {@link BootNotificationConfirm} from the Central System, and has no in-built
     * non-volatile real-time clock hardware that has been correctly preset, the Charge Point may not have a valid
     * date / time setting, making it impossible to later determine the date / time of transactions.
     * <p>
     * It might also be the case (e.g. due to configuration error) that the Central System indicates
     * a status other than Accepted for an extended period of time, or indefinitely.
     * <p>
     * It is usually advisable to deny all charging services at a Charge Point if the Charge Point has never before
     * been Accepted by the Central System (using the current connection settings, URL, etc.) since users cannot be
     * authenticated and running transactions could conflict with provisioning processes.
     * @param request {@link BootNotificationRequest}
     * @return {@link BootNotificationConfirm}
     */
    @PostMapping("/BootNotification")
    public BootNotificationConfirm handleBootNotificationRequest(@RequestBody BootNotificationRequest request) {
        try {
            ChargePoint chargePoint = chargePointService.findChargePoint(request);
            LOG.debug("Processing BootNotification on {}", chargePoint);
            return BootNotificationConfirm
                .builder()
                .status(RegistrationStatus.ACCEPTED)
                .currentTime(DateFormatter.parseISO8601( new Date() ))
                .interval(HEARTBEAT_INTERVAL)
                .build();

        } catch (NoResultException e) {
            LOG.debug("Charge Point {} is not enlisted", ChargePoint.parseChargePoint(request));
            return BootNotificationConfirm
                .builder()
                .currentTime(DateFormatter.parseISO8601( new Date() ))
                .interval(HEARTBEAT_INTERVAL)
                .status(RegistrationStatus.REJECTED)
                .build();
        }
    }

    /**
     * <h1>4.3. Data Transfer</h1>
     * <p>
     * If a Charge Point needs to send information to the Central System for a function not supported by OCPP,
     * it SHALL use the {@link DataTransferRequest} PDU.
     * <p>
     * The vendorId in the request SHOULD be known to the Central System and uniquely identify
     * the vendor-specific implementation. The VendorId SHOULD be a value from the reversed DNS namespace,
     * where the top tiers of the name, when reversed,
     * should correspond to the publicly registered primary DNS name of the Vendor organisation.
     * <p>
     * Optionally, the messageId in the request PDU MAY be used to indicate a specific message or implementation.
     * <p>
     * The length of data in both the request and response PDU is undefined and should be agreed upon by all parties involved.
     * <p>
     * If the recipient of the request has no implementation for the specific vendorId it SHALL return
     * a status ‘UnknownVendor’ and the data element SHALL not be present. In case of a messageId mismatch (if used)
     * the recipient SHALL return status ‘UnknownMessageId’.
     * In all other cases the usage of status ‘Accepted’ or ‘Rejected’ and the data element is part of
     * the vendor-specific agreement between the parties involved.
     *
     * @param request {@link DataTransferRequest}
     * @return {@link DataTransferConfirm}
     */
    @PostMapping("DataTransfer")
    public DataTransferConfirm handleDataTransferRequest(DataTransferRequest request) {
        return DataTransferConfirm.builder().data("").status(DataTransferStatus.REJECTED).build();
    }

    /**
     * <h1>4.4. Diagnostics Status Notification</h1>
     * <p>
     * Charge Point sends a notification to inform the Central System about the status of a diagnostics upload.
     * The Charge Point SHALL send a {@link DiagnosticsStatusNotificationRequest} PDU to inform the Central System that the upload
     * of diagnostics is busy or has finished successfully or failed. The Charge Point SHALL only send the status Idle
     * after receipt of a TriggerMessage for a Diagnostics Status Notification, when it is not busy uploading diagnostics.
     * @param request {@link DiagnosticsStatusNotificationRequest}
     * @return {@link DiagnosticsStatusNotificationConfirm}
     */
    @PostMapping("DiagnosticsStatusNotification")
    public DiagnosticsStatusNotificationConfirm handleDiagnosticsStatusNotificationRequest(@RequestBody DiagnosticsStatusNotificationRequest request) {
        return DiagnosticsStatusNotificationConfirm.builder().build();
    }

    /**
     * <h1>4.5. Firmware Status Notification</h1>
     * <p>
     * A Charge Point sends notifications to inform the Central System about the progress of the firmware update.
     * The Charge Point SHALL send a {@link FirmwareStatusNotificationRequest} PDU for informing the Central System about
     * the progress of the downloading and installation of a firmware update. The Charge Point SHALL only send
     * the status Idle after receipt of a TriggerMessage for a Firmware Status Notification,
     * when it is not busy downloading/installing firmware.
     * <p>
     * Upon receipt of a {@link FirmwareStatusNotificationRequest} PDU,
     * the Central System SHALL respond with a {@link FirmwareStatusNotificationConfirm}
     * <p>
     * The {@link FirmwareStatusNotificationRequest} PDUs SHALL be sent to keep the Central System updated with
     * the status of the update process, started by the Central System with a {@link UpdateFirmwareRequest} PDU.
     * @param request {@link FirmwareStatusNotificationRequest}
     * @return {@link FirmwareStatusNotificationConfirm}
     */
    @PostMapping("FirmwareStatusNotification")
    public FirmwareStatusNotificationConfirm handleFirmwareNotificationRequest(@RequestBody FirmwareStatusNotificationRequest request) {
        return FirmwareStatusNotificationConfirm.builder().build();
    }

    /**
     * <h1>4.6. Heartbeat</h1>
     * <p>
     * To let the Central System know that a Charge Point is still connected,
     * a Charge Point sends a heartbeat after a configurable time interval.
     * <p>
     * The Charge Point SHALL send a {@link HeartbeatRequest} PDU for ensuring that the Central System knows that a Charge Point is still alive.
     * <p>
     * Upon receipt of a {@link HeartbeatRequest} PDU, the Central System SHALL respond with a {@link HeartBeatConfirm}.
     * The response PDU SHALL contain the current time of the Central System,
     * which is RECOMMENDED to be used by the Charge Point to synchronize its internal clock.
     * <p>
     * The Charge Point MAY skip sending a {{@link HeartbeatRequest}} PDU when another PDU has been sent to
     * the Central System within the configured heartbeat interval.
     * This implies that a Central System SHOULD assume availability of a Charge Point whenever a PDU has been received,
     * the same way as it would have, when it received a {@link HeartbeatRequest} PDU.
     * @param request {@link HeartbeatRequest}
     * @return {@link HeartBeatConfirm}
     */
    @PostMapping("/Heartbeat")
    public HeartBeatConfirm handleHeartBeatRequest(@RequestBody HeartbeatRequest request) {
        return HeartBeatConfirm
            .builder()
            .currentTime(DateFormatter.parseISO8601( new Date() ))
            .build();
    }

    /**
     * <h1>4.7. Meter Values</h1>
     * <p>
     *     A Charge Point MAY sample the electrical meter or other sensor/transducer hardware to provide extra information
     *     about its meter values. It is up to the Charge Point to decide when it will send meter values.
     *     This can be configured using the {@link ChangeConfigurationRequest} message to data acquisition intervals
     *     and specify data to be acquired & reported.
     * </p>
     *
     * <p>
     *     The Charge Point SHALL send a {@link MeterValue} PDU for offloading meter values.
     *     The request PDU SHALL contain for each sample:
     *     <ol>
     *          <li>
     *              The id of the Connector from which samples were taken.
     *              If the connectorId is 0, it is associated with the entire Charge Point.
     *              If the connectorId is 0 and the {@link Measurand} is energy related, the sample SHOULD be taken from the main energy meter.
     *          </li>
     *          <li>
     *              The transactionId of the transaction to which these values are related, if applicable.
     *              If there is no transaction in progress or if the values are taken from the main meter,
     *              then transaction id may be omitted.
     *          </li>
     *          <li>
     *              One or more meterValue elements, of type MeterValue,
     *              each representing a set of one or more data values taken at a particular point in time.
     *          </li>
     *      </ol>
     * </p>
     * <p>
     *     Each MeterValue element contains a timestamp and a set of one or more individual {@link SampledValue} elements,
     *     all captured at the same point in time. Each sampledValue element contains a single value datum.
     *     The nature of each sampledValue is determined by the optional {@link Measurand}, context, location, unit, phase, and format fields.
     * </p>
     * <p>The optional {@link Measurand} field specifies the type of value being measured/reported.</p>
     * <p>The optional context field specifies the reason/event triggering the reading.</p>
     * <p>The optional location field specifies where the measurement is taken (e.g. Inlet, Outlet).</p>
     * <p>
     *     The optional phase field specifies to which phase or phases of the electric installation the value applies.
     *     The Charging Point SHALL report all phase number dependent values from the electrical meter (or grid connection when absent) point of view.
     * </p>
     * <h3>Important Notes:</h3>
     * <ul>
     *     <li>
     *         The phase field is not applicable to all {@link Measurand}.
     *     </li>
     *     <li>
     *         Two {@link Measurand} (Current.Offered and Power.Offered) are available that are strictly speaking no measured values.
     *         They indicate the maximum amount of current/power that is being offered to the EV and are intended for use in smart charging applications.
     *     </li>
     * </ul>
     * <p>
     *     For individual connector phase rotation information, the Central System MAY query the ConnectorPhaseRotation
     *     configuration key on the Charging Point via GetConfiguration.
     *     The Charge Point SHALL report the phase rotation in respect to the grid connection.
     *     Possible values per connector are:
     *     <ul>
     *         <li>NotApplicable</li>
     *         <li>Unknown</li>
     *         <li>RST</li>
     *         <li>RTS</li>
     *         <li>SRT</li>
     *         <li>STR</li>
     *         <li>TRS</li>
     *         <li>TSR</li>
     *     </ul>
     *     See Section Standard Configuration Key Names & Values for more information.
     * </p>
     * <p>
     *     The EXPERIMENTAL optional format field specifies whether the data is represented in the normal (default)
     *     form as a simple numeric value ("Raw"), or as “SignedData”, an opaque digitally signed binary data block,
     *     represented as hex data. This experimental field may be deprecated and subsequently removed in later versions,
     *     when a more mature solution alternative is provided.
     * </p>
     * <p>
     *     To retain backward compatibility, the default values of all of the optional fields on a sampledValue element
     *     are such that a value without any additional fields will be interpreted,
     *     as a register reading of active import energy in Wh (Watt-hour) units.
     * </p>
     * <p>
     *     Upon receipt of a {@link MeterValuesRequest} PDU, the Central System SHALL respond with a {@link MeterValuesConfirm}.
     * </p>
     * <p>
     *     It is likely that The Central System applies sanity checks to the data contained in a {@link MeterValuesRequest} it received.
     *     The outcome of such sanity checks SHOULD NOT ever cause the Central System to not respond with a {@link MeterValuesConfirm}.
     *     Failing to respond with a {@link MeterValuesConfirm} will only cause the Charge Point to
     *     try the same message again as specified in Error responses to transaction-related messages.
     * </p>
     * @param request {@link MeterValuesRequest}
     * @return {@link MeterValuesConfirm}
     */
    @PostMapping("MeterValues")
    public MeterValuesConfirm handleMeterValuesRequest(@RequestBody MeterValuesRequest request) {
        return MeterValuesConfirm.builder().build();
    }

    /**
     * <h1>4.8. Start Transaction</h1>
     * <p>
     *     The Charge Point SHALL send a {@link StartTransactionRequest} PDU to the Central System to inform about
     *     a transaction that has been started. If this transaction ends a reservation (see Reserve Now operation),
     *     then the {@link StartTransactionRequest} MUST contain the reservationId.
     * </p>
     * <p>
     *     Upon receipt of a {@link StartTransactionRequest} PDU,
     *     the Central System SHOULD respond with a {@link StartTransactionConfirm} PDU.
     *     This response PDU MUST include a transaction id and an authorization status value.
     * </p>
     * <p>
     *     The Central System MUST verify validity of the identifier in the {@link StartTransactionRequest} PDU,
     *     because the identifier might have been authorized locally by the Charge Point using outdated information.
     *     The identifier, for instance, may have been blocked since it was added to the Charge Point’s Authorization Cache.
     * </p>
     * <p>
     *     If Charge Point has implemented an Authorization Cache,
     *     then upon receipt of a {@link StartTransactionConfirm} PDU the Charge Point SHALL update the cache entry,
     *     if the idTag is not in the Local Authorization List,
     *     with the IdTagInfo value from the response as described under Authorization Cache.
     * </p>
     * <p>
     *     It is likely that The Central System applies sanity checks to the data contained in a {@link StartTransactionRequest} it received.
     *     The outcome of such sanity checks SHOULD NOT ever cause the Central System to not respond with a {@link StartTransactionConfirm}.
     *     Failing to respond with a {@link StartTransactionConfirm} will only cause the Charge Point to
     *     try the same message again as specified in Error responses to transaction-related messages.
     * </p>
     * @param request {@link StartTransactionRequest}
     * @return {@link StartTransactionConfirm}
     */
    @PostMapping("/StartTransaction")
    public StartTransactionConfirm handleStartTransactionRequest(@RequestBody StartTransactionRequest request) {
        return StartTransactionConfirm
            .builder()
            .idTagInfo(IdTagInfo
                .builder()
                .expiryDate(DateFormatter.parseISO8601(new Date()))
                .status(AuthorizationStatus.ACCEPTED)
                .build())
            .transactionId(100)
            .build();
    }

    /**
     * <h1>4.9. Status Notification</h1>
     * <p>
     *     A Charge Point sends a notification to the Central System to inform the Central System about
     *     a status change or an error within the Charge Point. The following table depicts changes from
     *     a previous status (left column) to a new status (upper row) upon which a Charge Point MAY send
     *     a {@link StatusNotificationRequest} PDU to the Central System.
     * </p>
     * <p>
     *     As the status Occupied has been split into five new statuses (Preparing, Charging, SuspendedEV, SuspendedEVSE and Finishing),
     *     more {@link StatusNotificationRequest} PDUs will be sent from Charge Point to the Central System.
     *     For instance, when a transaction is started, the Connector status would successively change
     *     from Preparing to Charging with a short SuspendedEV and/or SuspendedEVSE in-between,
     *     possibly within a couple of seconds.
     * </p>
     * <p>
     *     To limit the number of transitions,
     *     the Charge Point MAY omit sending a {@link StatusNotificationRequest} if it was active for less time than
     *     defined in the optional configuration key MinimumStatusDuration.
     *     This way, a Charge Point MAY choose not to send certain {@link StatusNotificationRequest} PDUs.
     * </p>
     * <p></p>
     * <h3>Important Notes</h3>
     * <ul>
     *     <li>
     *         A Charge Point manufacturer MAY have implemented a minimal status duration for certain status transitions
     *         separate of the MinimumStatusDuration setting. The time set in MinimumStatusDuration will be added to this default delay.
     *         Setting MinimumStatusDuration to zero SHALL NOT override the default manufacturer’s minimal status duration.
     *     </li>
     *     <li>
     *         Setting a high MinimumStatusDuration time may result in the delayed sending of all StatusNotifications,
     *         since the Charge Point will only send the {@link StatusNotificationRequest} once the MinimumStatusDuration time is passed.
     *     </li>
     * </ul>
     * <p>
     *     The Charge Point MAY send a {@link StatusNotificationRequest} PDU to inform the Central System of fault conditions.
     *     When the 'status' field is not Faulted, the condition should be considered a warning since charging operations are still possible.
     *
     * </p>
     * <h3>Important Notes</h3>
     * <ul>
     *     <li>ChargePointErrorCode EVCommunicationError SHALL only be used with status Preparing, SuspendedEV, SuspendedEVSE and Finishing and be treated as warning.</li>
     * </ul>
     * <p>
     *     When a Charge Point is configured with StopTransactionOnEVSideDisconnect set to false,
     *     a transaction is running and the EV becomes disconnected on EV side, then a {@link StatusNotificationRequest}
     *     with the state: SuspendedEV SHOULD be send to the Central System, with the 'errorCode' field set to: 'NoError'.
     *     The Charge Point SHOULD add additional information in the 'info' field, Notifying the Central System with
     *     the reason of suspension: 'EV side disconnected'. The current transaction is not stopped.
     * </p>
     * <p>
     *     When a Charge Point is configured with StopTransactionOnEVSideDisconnect set to true,
     *     a transaction is running and the EV becomes disconnected on EV side,
     *     then a {@link StatusNotificationRequest} with the state: 'Finishing' SHOULD be send to the Central System,
     *     with the 'errorCode' field set to: 'NoError'.
     *     The Charge Point SHOULD add additional information in the 'info' field, Notifying the Central System with
     *     the reason of stopping: 'EV side disconnected'. The current transaction is stopped.
     * </p>
     * <p>
     *     When a Charge Point connects to a Central System after having been offline,
     *     it updates the Central System about its status according to the following rules:
     *     <ul>
     *         <li>
     *             The Charge Point SHOULD send a {@link StatusNotificationRequest} PDU with its current status
     *             if the status changed while the Charge Point was offline.
     *         </li>
     *         <li>
     *             The Charge Point MAY send a {@link StatusNotificationRequest} PDU to report an error that occurred
     *             while the Charge Point was offline.
     *         </li>
     *         <li>
     *             The Charge Point SHOULD NOT send {@link StatusNotificationRequest} PDUs for historical status change
     *             events that happened while the Charge Point was offline and that do not inform the Central System of
     *             Charge Point errors or the Charge Point’s current status.
     *         </li>
     *         <li>
     *             The {@link StatusNotificationRequest} messages MUST be sent in the order in which the events that
     *             they describe occurred.
     *         </li>
     *     </ul>
     * </p>
     * <p>
     *     Upon receipt of a {@link StatusNotificationRequest}, the Central System SHALL respond with a {@link StatusNotificationConfirm} PDU.
     * </p>
     * @param request {@link StatusNotificationRequest}
     * @return {@link StatusNotificationConfirm}
     */
    @PostMapping("/StatusNotification")
    public StatusNotificationConfirm handleStatusNotificationConfirm(@RequestBody StatusNotificationRequest request) {
        return StatusNotificationConfirm.builder().build();
    }

    /**
     * <h1>4.10. Stop Transaction</h1>
     * <p>
     *     When a transaction is stopped, the Charge Point SHALL send a {@link StopTransactionRequest} PDU,
     *     notifying to the Central System that the transaction has stopped.
     * </p>
     * <p>
     *     A {@link StopTransactionRequest} PDU MAY contain an optional TransactionData element to provide more details
     *     about transaction usage. The optional TransactionData element is a container for any number of {@link MeterValue},
     *     using the same data structure as the {@link MeterValue} elements of the {@link MeterValuesRequest} PDU (See section MeterValues)
     * </p>
     * <p>
     *     Upon receipt of a {@link StopTransactionRequest} PDU,
     *     the Central System SHALL respond with a {@link StopTransactionConfirm} PDU.
     * </p>
     * <h3>Important Notes:</h3>
     * <ul>
     *     <li>
     *         The Central System cannot prevent a transaction from stopping.
     *         It MAY only inform the Charge Point it has received the {@link StopTransactionRequest} and MAY send information
     *         about the idTag used to stop the transaction.
     *         This information SHOULD be used to update the Authorization Cache, if implemented.
     *     </li>
     * </ul>
     * <p>
     *     The idTag in the request PDU MAY be omitted when the Charge Point itself needs to stop the transaction.
     *     For instance, when the Charge Point is requested to reset.
     * </p>
     * <p>
     *     If a transaction is ended in a normal way (e.g. EV-driver presented his identification to stop the transaction),
     *     the Reason element MAY be omitted and the Reason SHOULD be assumed 'Local'.
     *     If the transaction is not ended normally, the Reason SHOULD be set to a correct value.
     *     As part of the normal transaction termination, the Charge Point SHALL unlock the cable (if not permanently attached).
     * </p>
     * <p>
     *     The Charge Point MAY unlock the cable (if not permanently attached) when the cable is disconnected at the EV.
     *     If supported, this functionality is reported and controlled by the configuration key UnlockConnectorOnEVSideDisconnect.
     * </p>
     * <p>
     *     The Charge Point MAY stop a running transaction when the cable is disconnected at the EV.
     *     If supported, this functionality is reported and controlled by the configuration key StopTransactionOnEVSideDisconnect.
     * </p>
     * <p>
     *     If StopTransactionOnEVSideDisconnect is set to false,
     *     the transaction SHALL not be stopped when the cable is disconnected from the EV.
     *     If the EV is reconnected, energy transfer is allowed again.
     *     In this case there is no mechanism to prevent other EVs from charging and disconnecting during that same
     *     ongoing transaction. With UnlockConnectorOnEVSideDisconnect set to false, the Connector SHALL remain locked
     *     at the Charge Point until the user presents the identifier.
     * </p>
     * <p>
     *     By setting StopTransactionOnEVSideDisconnect to true, the transaction SHALL be stopped when the cable is
     *     disconnected from the EV. If the EV is reconnected, energy transfer is not allowed until the transaction is
     *     stopped and a new transaction is started. If UnlockConnectorOnEVSideDisconnect is set to true,
     *     also the Connector on the Charge Point will be unlocked.
     * </p>
     * <h3>Important Notes:</h3>
     * <ul>
     *     <li>
     *         If StopTransactionOnEVSideDisconnect is set to false,
     *         this SHALL have priority over UnlockConnectorOnEVSideDisconnect.
     *         In other words: cables always remain locked when the cable is disconnected at EV side
     *         when StopTransactionOnEVSideDisconnect is false.
     *     </li>
     *     <li>
     *         Setting StopTransactionOnEVSideDisconnect to true will prevent sabotage acts to stop the energy flow
     *         by unplugging not locked cables on EV side.
     *     </li>
     * </ul>
     * <p>
     *     It is likely that The Central System applies sanity checks to the data contained in a {@link StopTransactionRequest} it received.
     *     The outcome of such sanity checks SHOULD NOT ever cause the Central System to not respond with a {@link StopTransactionConfirm}.
     *     Failing to respond with a {@link StopTransactionConfirm} will only cause the Charge Point
     *     to try the same message again as specified in Error responses to transaction-related messages.
     * </p>
     * <p>
     *     If Charge Point has implemented an Authorization Cache,
     *     then upon receipt of a {@link StopTransactionConfirm} PDU the Charge Point SHALL update the cache entry,
     *     if the idTag is not in the Local Authorization List,
     *     with the IdTagInfo value from the response as described under Authorization Cache.
     * </p>
     * @param request {@link StopTransactionRequest}
     * @return {@link StopTransactionConfirm}
     */
    @PostMapping("/StopTransaction")
    public StopTransactionConfirm handleStopTransactionRequest(@RequestBody StopTransactionRequest request) {
        return StopTransactionConfirm
            .builder()
            .idTagInfo(IdTagInfo
                .builder()
                .expiryDate(DateFormatter.parseISO8601(new Date()))
                .status(AuthorizationStatus.ACCEPTED)
                .build())
            .build();
    }

}
