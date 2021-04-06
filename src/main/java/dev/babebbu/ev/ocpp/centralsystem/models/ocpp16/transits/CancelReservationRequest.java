package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class CancelReservationRequest implements CallAction {

    private static final String ACTION = "CancelReservation";

    /**
     * Required. Id of the reservation to cancel.
     */
    @NonNull
    private int reservationId;

    @Override
    public String getAction() {
        return ACTION;
    }
}
