package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ResetStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ResetConfirm {
    /**
     * Required. This indicates whether the Charge Point is able to perform the reset.
     */
    @NonNull
    private ResetStatus status;
}
