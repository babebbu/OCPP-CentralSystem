package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ChargingProfilePurposeType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClearChargingProfileRequest {
    /**
     * Optional. The ID of the charging profile to clear.
     */
    private int id;

    /**
     * Optional. Specifies the ID of the connector for which to clear charging profiles.
     * A connectorId of zero (0) specifies the charging profile for the overall Charge Point.
     * Absence of this parameter means the clearing applies to all charging profiles that match the other criteria in the request.
     */
    private int connectorId;

    /**
     * Optional. Specifies to purpose of the charging profiles that will be cleared, if they meet the other criteria in the request.
     */
    private ChargingProfilePurposeType chargingProfilePurpose;

    /**
     * Optional. specifies the stackLevel for which charging profiles will be cleared, if they meet the other criteria in the request
     */
    private int stackLevel;
}
