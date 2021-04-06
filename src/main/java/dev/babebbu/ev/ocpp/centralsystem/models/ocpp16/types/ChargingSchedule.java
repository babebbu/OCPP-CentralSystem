package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ChargingSchedule {
    /**
     * Optional. Duration of the charging schedule in seconds. If the duration is left empty,
     * the last period will continue indefinitely or until end of the transaction in case startSchedule is absent.
     */
    private int duration;

    /**
     * Optional. Starting point of an absolute schedule. If absent the schedule will be relative to start of charging.
     */
    private Date startSchedule;

    /**
     * Required. The unit of measure Limit is expressed in.
     */
    private ChargingRateUnitType chargingRateUnit;

    /**
     * Required. List of ChargingSchedulePeriod elements defining maximum power or current usage over time.
     * The startSchedule of the first ChargingSchedulePeriod SHALL always be 0.
     */
    private ChargingSchedulePeriod chargingSchedulePeriod;

    /**
     * Optional. Minimum charging rate supported by the electric vehicle.
     * The unit of measure is defined by the chargingRateUnit.
     * This parameter is intended to be used by a local smart charging algorithm to optimize the power allocation for
     * in the case a charging process is inefficient at lower charging rates.
     * Accepts at most one digit fraction (e.g. 8.1)
     */
    private double minChargingRate;
}
