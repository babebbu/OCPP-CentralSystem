package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ClearCacheStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ClearCacheConfirm {
    /**
     * Required. Accepted if the Charge Point has executed the request, otherwise rejected.
     */
    @NonNull
    private ClearCacheStatus status;
}
