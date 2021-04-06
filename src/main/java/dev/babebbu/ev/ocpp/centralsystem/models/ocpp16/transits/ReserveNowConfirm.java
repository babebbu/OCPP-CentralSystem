package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ReservationStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ReserveNowConfirm {

    /**
     * Required. This indicates the success or failure of the reservation.
     */
    @NonNull
    private ReservationStatus status;

}
