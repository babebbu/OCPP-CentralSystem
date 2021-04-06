package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.UnlockStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UnlockConnectorConfirm {
    /**
     * Required. This indicates whether the Charge Point has unlocked the connector.
     */
    private UnlockStatus status;
}
