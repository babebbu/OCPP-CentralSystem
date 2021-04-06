package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.TriggerMessageStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class TriggerMessageConfirm {
    /**
     * Required. Indicates whether the Charge Point will send the requested notification or not.
     */
    @NonNull
    private TriggerMessageStatus status;
}
