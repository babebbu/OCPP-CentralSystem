package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.AvailabilityStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ChangeAvailabilityConfirm {
    /**
     * Required. This indicates whether the Charge Point is able to perform the availability change.
     */
    @NonNull
    private AvailabilityStatus status;
}
