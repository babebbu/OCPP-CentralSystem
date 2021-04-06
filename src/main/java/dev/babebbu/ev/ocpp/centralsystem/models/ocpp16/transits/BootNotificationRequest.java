package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BootNotificationRequest {
    /**
     * Optional. This contains a value that identifies the serial number of the Charge Box inside the Charge Point.
     * Deprecated, will be removed in future version
     */
    @Deprecated
    private String chargeBoxSerialNumber;

    /**
     * Required. This contains a value that identifies the model of the ChargePoint.
     */
    @NonNull
    private String chargePointModel;

    /**
     * Optional. This contains a value that identifies the serial number of the Charge Point.
     */
    private String chargePointSerialNumber;

    /**
     * Required. This contains a value that identifies the vendor of the ChargePoint.
     */
    @NonNull
    private String chargePointVendor;

    /**
     * Optional. This contains the firmware version of the Charge Point.
     */
    private String firmwareVersion;

    /**
     * Optional. This contains the ICCID of the modem’s SIM card.
     */
    private String iccid;

    /**
     * Optional. This contains the IMSI of the modem’s SIM card.
     */
    private String imsi;

    /**
     * Optional. This contains the serial number of the main electrical meter of the Charge Point.
     */
    private String meterSerialNumber;

    /**
     * Optional. This contains the type of the main electrical meter of the Charge Point.
     */
    private String meterType;
}
