package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChargingSchedulePeriod {
    /**
     * Required. Start of the period, in seconds from the start of schedule.
     * The value of StartPeriod also defines the stop time of the previous period.
     */
    private int startPeriod;

    /**
     * Required. Charging rate limit during the schedule period, in the applicable chargingRateUnit,
     * for example in Amperes or Watts. Accepts at most one digit fraction (e.g. 8.1).
     */
    private int limit;

    /**
     * Optional. The number of phases that can be used for charging. If a number of phases is needed,
     * numberPhases=3 will be assumed unless another number is given.
     */
    private int numberPhases;
}
