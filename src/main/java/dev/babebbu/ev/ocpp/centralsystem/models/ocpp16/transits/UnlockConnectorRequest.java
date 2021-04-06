package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class UnlockConnectorRequest {
    /**
     * Required. This contains the identifier of the connector to be unlocked.
     */
    @NonNull
    private int connectorId;
}
