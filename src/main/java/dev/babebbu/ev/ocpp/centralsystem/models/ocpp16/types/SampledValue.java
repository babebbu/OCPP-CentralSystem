package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SampledValue {

    /**
     * Required. Value as a “Raw” (decimal) number or “SignedData”.
     * Field Type is “string” to allow for digitally signed data readings.
     * Decimal numeric values are also acceptable to allow fractional values for measurands such as Temperature and Current.
     */
    private String value;

    /**
     * Optional. Type of detail value: start, end or sample. Default = “Sample.Periodic”
     */
    private ReadingContext context;

    /**
     * Optional. Raw or signed data. Default = “Raw”
     */
    private ValueFormat format;

    /**
     * Optional. Type of measurement. Default = “Energy.Active.Import.Register”
     */
    private Measurand measurand;

    /**
     * Optional. indicates how the measured value is to be interpreted.
     * For instance between L1 and neutral (L1-N) Please note that not all values of phase are applicable to all Measurands.
     * When phase is absent, the measured value is interpreted as an overall value.
     */
    private Phase phase;

    /**
     * Optional. Location of measurement. Default=”Outlet”
     */
    private Location location;

    /**
     * Optional. Unit of the value. Default = “Wh” if the (default) measurand is an “Energy” type.
     */
    private UnitOfMeasure unit;

    public String getReadingContext() {
        return context.getValue();
    }

    public String getValueFormat() {
        return format.getValue();
    }

    public String getMeasurand() {
        return measurand.getValue();
    }

    public String getPhase() {
        return phase.getValue();
    }

    public String getLocation() {
        return location.getValue();
    }

    public String getUnitOfMeasure() {
        return unit.getValue();
    }

}
