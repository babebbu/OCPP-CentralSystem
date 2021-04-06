package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ChargingSchedule;
import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.GetCompositeScheduleStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class GetCompositeScheduleConfirm {
    /**
     * Required. Status of the request. The Charge Point will indicate if it was able to process the request
     */
    @NonNull
    private GetCompositeScheduleStatus status;

    /**
     * Optional. The charging schedule contained in this notification applies to a Connector.
     */
    private int connectorId;

    /**
     * Optional. Time. Periods contained in the charging profile are relative to this point in time.
     * If status is "Rejected", this field may be absent.
     */
    private String scheduleStart;

    /**
     * Optional. Planned Composite Charging Schedule, the energy consumption over time. Always relative to ScheduleStart.
     * If status is "Rejected", this field may be absent.
     */
    private ChargingSchedule chargingSchedule;
}
