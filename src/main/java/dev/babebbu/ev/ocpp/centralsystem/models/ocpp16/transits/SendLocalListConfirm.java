package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.UpdateStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class SendLocalListConfirm {
    /**
     * Required. This indicates whether the Charge Point has successfully received and applied the update of the local authorization list.
     */
    @NonNull
    private UpdateStatus status;
}
