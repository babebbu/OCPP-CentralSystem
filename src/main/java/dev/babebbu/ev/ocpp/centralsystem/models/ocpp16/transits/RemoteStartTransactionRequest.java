package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ChargingProfile;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemoteStartTransactionRequest implements CallAction {

    private static final String ACTION = "RemoteStartTransaction";

    /**
     * Optional. Number of the connector on which to start the transaction. connectorId SHALL be > 0
     */
    private int connectorId;

    /**
     * Required. The identifier that Charge Point must use to start a transaction.
     */
    @NonNull
    private String idTag;

    /**
     * Optional. Charging Profile to be used by the Charge Point for the requested transaction. ChargingProfilePurpose MUST be set to TxProfile
     */
    private ChargingProfile chargingProfile;

    public RemoteStartTransactionRequest(String idTag) {
        setIdTag(idTag);
    }

    public String getAction() {
        return ACTION;
    }

}
