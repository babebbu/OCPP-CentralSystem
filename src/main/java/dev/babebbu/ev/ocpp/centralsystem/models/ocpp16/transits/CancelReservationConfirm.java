package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.CancelReservationStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class CancelReservationConfirm {
    /**
     * Required. This indicates the success or failure of the cancelling of a reservation by Central System.
     */
    @NonNull
    private CancelReservationStatus status;
}
