package dev.babebbu.ev.ocpp.centralsystem.http.ocpp.v16;

import dev.babebbu.ev.ocpp.centralsystem.models.entities.ChargePoint;
import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits.*;
import dev.babebbu.ev.ocpp.centralsystem.repositories.ChargePointRepository;
import dev.babebbu.ev.ocpp.centralsystem.services.ChargePointService;
import dev.babebbu.ev.ocpp.centralsystem.utils.DateFormatter;
import dev.babebbu.ev.ocpp.centralsystem.websocket.MessageSender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <h1>5. Operations Initiated by Central System</h1>
 * <p>This class includes methods which are handling data internally submitted from websocket endpoint.
 * @author Natthasak Vechprasit
 */
@RestController
@RequestMapping("/centralsystem/charge-points")
public class Ocpp16CentralSystemController {

    private final ChargePointRepository chargePointRepository;

    private final ChargePointService chargePointService;

    public Ocpp16CentralSystemController(ChargePointRepository chargePointRepository, ChargePointService chargePointService) {
        this.chargePointRepository = chargePointRepository;
        this.chargePointService = chargePointService;
    }

    private ResponseEntity<?> acceptedResponse() {
        return ResponseEntity.accepted().body(Map.of(
            "message", "The request is accepted and is executing asynchronously."
        ));
    }

    private void broadcastMessage(CallAction message) {
        MessageSender.broadcastMessage(message);
    }

    @GetMapping
    public List<ChargePoint> list() {
        return chargePointRepository.findAll();
    }

    @GetMapping("/{id}")
    public ChargePoint get(@PathVariable int id) {
        return chargePointRepository.findById(id).orElseThrow();
    }

    /**
     * <h1>5.1 Cancel Reservation</h1>
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    @PostMapping("/{id}/cancel-reservation")
    public ResponseEntity<?> cancelReservation(@PathVariable String id) {
        broadcastMessage(CancelReservationRequest
            .builder()
            .reservationId(1234567890)
            .build()
        );
        return acceptedResponse();
    }

    /**
     * <h1>5.2. Change Availability</h1>
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    @PostMapping("/{id}/change-availability")
    public ResponseEntity<?> changeAvailability(@PathVariable String id) {
        broadcastMessage(ChangeAvailabilityRequest
            .builder()
            .connectorId(1)
            .build()
        );
        return acceptedResponse();
    }

    /**
     * <h1>5.3. Change Configuration</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> changeConfiguration(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.4. Clear Cache</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> clearCache(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.5. Clear Charging Profile</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> clearChangingProfile(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.6 Data Transfer</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> dataTransfer(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.7. Get Composite Schedule</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> getCompositeSchedule(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.8. Get Configuration</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> getConfiguration(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.9. Get Diagnostics</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> getDiagnostics(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.10. Get Local List Version</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> getLocalListVersion(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.11. Remote Start Transaction</h1>
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    @PostMapping("/{id}/remote-start-transaction")
    public ResponseEntity<?> remoteStartTransaction(@PathVariable String id) {
        MessageSender.broadcastMessage(RemoteStartTransactionRequest
            .builder()
            .connectorId(1)
            .idTag("1234567890")
            .build()
        );
        return acceptedResponse();
    }

    /**
     * <h1>5.12. Remote Stop Transaction</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> remoteStopTransaction(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.13. Reserve Now</h1>
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     * @throws IOException
     */
    @PostMapping("/{id}/reserve-now")
    public ResponseEntity<?> reserveNow(@PathVariable String id) throws IOException {
        final int HOUR_IN_SECOND = 60 * 60;
        MessageSender.broadcastMessage(ReserveNowRequest
            .builder()
            .connectorId(1)
            .expiryDate(DateFormatter.parseISO8601(Date.from(Instant.now().plusSeconds(HOUR_IN_SECOND))))
            .idTag("1234567890")
            .reservationId(1000)
            .build()
        );
        return acceptedResponse();
    }

    /**
     * <h1>5.14. Reset</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> reset(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.15. Send Local List</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> sendLocalList(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.16. Set Charging Profile</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> setChargingProfile(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.17. Trigger Message</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> triggerMessage(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.18. Unlock Connector</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> unlockConnector(@PathVariable String id) {
        return acceptedResponse();
    }

    /**
     * <h1>5.19. Update Firmware</h1>
     *
     * @param id Charge Point ID: String
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<?> updateFirmware(@PathVariable String id) {
        return acceptedResponse();
    }


}
