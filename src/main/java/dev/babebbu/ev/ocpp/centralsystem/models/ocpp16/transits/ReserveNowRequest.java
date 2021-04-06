package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ReserveNowRequest implements CallAction {

    private static final String ACTION = "ReserveNow";

    /**
     * Required. This contains the id of the connector to be reserved. A value of 0 means that the reservation is not for a specific connector.
     */
    @NonNull
    private int connectorId;

    /**
     * Required. This contains the date and time when the reservation ends.
     */
    @NonNull
    private String expiryDate;

    /**
     * Required. The identifier for which the Charge Point has to reserve a connector.
     */
    @NonNull
    private String idTag;

    /**
     * Optional. The parent idTag.
     */
    private String parentIdTag;

    /**
     * Required. Unique id for this reservation.
     */
    @NonNull
    private int reservationId;

    @Override
    public String getAction() {
        return ACTION;
    }
}
