package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ChargingProfile;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class SetChargingProfileRequest {
    /**
     * Required. The connector to which the charging profile applies. If connectorId = 0, the message contains an overall limit for the Charge Point.
     */
    @NonNull
    private int connectorId;

    /**
     * Required. The charging profile to be set at the Charge Point.
     */
    private ChargingProfile csChargingProfiles;
}
