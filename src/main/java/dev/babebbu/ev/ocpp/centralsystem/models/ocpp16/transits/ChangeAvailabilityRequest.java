package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.AvailabilityType;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ChangeAvailabilityRequest implements CallAction{

    private static final String ACTION = "ChangeAvailability";

    /**
     * Required. The id of the connector for which availability needs to change.
     * Id '0' (zero) is used if the availability of the Charge Point and all its connectors needs to change.
     */
    @NonNull
    private int connectorId;

    /**
     * Required. This contains the type of availability change that the Charge Point should perform.
     */
    @NonNull
    private AvailabilityType type;

    @Override
    public String getAction() {
        return ACTION;
    }
}
