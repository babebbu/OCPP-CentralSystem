package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class GetLocalListVersionConfirm {
    /**
     * Required. This contains the current version number of the local authorization list in the Charge Point.
     */
    @NonNull
    private int listVersion;
}
