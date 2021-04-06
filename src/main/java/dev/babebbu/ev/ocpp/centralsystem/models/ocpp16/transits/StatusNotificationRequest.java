package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ChargePointErrorCode;
import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ChargePointStatus;
import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.EnumOperator;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusNotificationRequest {
    /**
     * Required. The id of the connector for which the status is reported. Id '0' (zero) is used if the status is for the Charge Point main controller.
     */
    @NonNull
    private int connectorId;

    /**
     * Required. This contains the error code reported by the Charge Point.
     */
    @NonNull
    private ChargePointErrorCode errorCode;

    /**
     * Optional. Additional free format information related to the error.
     */
    private String info;

    /**
     * Required. This contains the current status of the Charge Point.
     */
    @NonNull
    private ChargePointStatus status;

    /**
     * Optional. The time for which the status is reported. If absent time of receipt of the message will be assumed.
     */
    private String timestamp;

    /**
     * Optional. This identifies the vendor-specific implementation.
     */
    private String vendorId;

    /**
     * Optional. This contains the vendor-specific error code.
     */
    private String vendorErrorCode;

    public void setErrorCode(String s) {
        errorCode = EnumOperator.from(ChargePointErrorCode.values(), s);
    }

    public void setStatus(String s) {
        status = EnumOperator.from(ChargePointStatus.values(), s);
    }

    public String getErrorCode() {
        return errorCode.getValue();
    }

    public String getStatus() {
        return status.getValue();
    }

}
