package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ClearChargingProfileStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ClearChargingProfileConfirm {
    /**
     * Required. Indicates if the Charge Point was able to execute the request.
     */
    @NonNull
    private ClearChargingProfileStatus status;
}
