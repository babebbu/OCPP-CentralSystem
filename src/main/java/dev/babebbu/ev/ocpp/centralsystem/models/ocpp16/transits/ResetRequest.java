package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ResetType;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ResetRequest {
    /**
     * Required. This contains the type of reset that the Charge Point should perform.
     */
    @NonNull
    private ResetType type;
}
