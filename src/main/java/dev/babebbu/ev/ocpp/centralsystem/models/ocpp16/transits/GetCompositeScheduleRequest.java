package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ChargingRateUnitType;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class GetCompositeScheduleRequest {
    /**
     * Required. The ID of the Connector for which the schedule is requested. When ConnectorId=0,
     * the Charge Point will calculate the expected consumption for the grid connection.
     */
    @NonNull
    private int connectorId;

    /**
     * Required. Time in seconds. length of requested schedule
     */
    @NonNull
    private int duration;

    /**
     * Optional. Can be used to force a power or current profile
     */
    private ChargingRateUnitType chargingRateUnit;
}
