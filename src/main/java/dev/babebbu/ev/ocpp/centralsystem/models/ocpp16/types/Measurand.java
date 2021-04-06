package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum Measurand {

    /**
     * Instantaneous current flow from EV
     */
    CURRENT_EXPORT("Current.Export", "Instantaneous current flow from EV"),

    /**
     * Instantaneous current flow to EV
     */
    CURRENT_IMPORT("Current.Import", "Instantaneous current flow to EV"),

    /**
     * Maximum current offered to EV
     */
    CurrentOffered("Current.Offered", "Maximum current offered to EV"),


    /**
     * Numerical value read from the "active electrical energy" (Wh or kWh) register of
     * the (most authoritative) electrical meter measuring energy exported (to the grid).
     */
    ENERGY_ACTIVE_EXPORT_REGISTER("Energy.Active.Export.Register", """
        Numerical value read from the "active electrical energy" (Wh or kWh) register of the (most authoritative) electrical meter measuring energy exported (to the grid)."""),

    /**
     * Numerical value read from the "active electrical energy" (Wh or kWh) register of
     * the (most authoritative) electrical meter measuring energy imported (from the grid supply).
     */
    ENERGY_ACTIVE_IMPORT_REGISTER("Energy.Active.Import.Register", """
        Numerical value read from the "active electrical energy" (Wh or kWh) register of the (most authoritative) electrical meter measuring energy imported (from the grid supply)."""),

    /**
     * Absolute amount of "active electrical energy" (Wh or kWh) exported (to the grid)
     * during an associated time "interval", specified by a Meter Values ReadingContext,
     * and applicable interval duration configuration values (in seconds) for
     * "ClockAlignedDataInterval" and "MeterValueSampleInterval".
     */
    ENERGY_ACTIVE_EXPORT_INTERVAL("Energy.Active.Export.Interval", """
        Absolute amount of "active electrical energy" (Wh or kWh) exported (to the grid) during an associated time "interval", specified by a Meter Values ReadingContext, and applicable interval duration configuration values (in seconds) for "ClockAlignedDataInterval" and "MeterValueSampleInterval"."""),

    /**
     * Absolute amount of "active electrical energy" (Wh or kWh) imported (from the grid supply)
     * during an associated time "interval", specified by a Meter Values ReadingContext,
     * and applicable interval duration configuration values (in seconds) for
     * "ClockAlignedDataInterval" and "MeterValueSampleInterval".
     */
    ENERGY_ACTIVE_IMPORT_INTERVAL("Energy.Active.Import.Interval", """
        Absolute amount of "active electrical energy" (Wh or kWh) imported (from the grid supply) during an associated time "interval", specified by a Meter Values ReadingContext, and applicable interval duration configuration values (in seconds) for "ClockAlignedDataInterval" and "MeterValueSampleInterval"."""),


    /**
     *  Numerical value read from the "reactive electrical energy" (VARh or kVARh) register of
     *  the (most authoritative) electrical meter measuring energy exported (to the grid).
     */
    ENERGY_REACTIVE_EXPORT_REGISTER("Energy.Reactive.Export.Register", """
        Numerical value read from the "reactive electrical energy" (VARh or kVARh) register of the (most authoritative) electrical meter measuring energy exported (to the grid)."""),

    /**
     * Numerical value read from the "reactive electrical energy" (VARh or kVARh) register of
     * the (most authoritative) electrical meter measuring energy imported (from the grid supply).
     */
    ENERGY_REACTIVE_IMPORT_REGISTER("Energy.Reactive.Import.Register", """
        Numerical value read from the "reactive electrical energy" (VARh or kVARh) register of the (most authoritative) electrical meter measuring energy imported (from the grid supply)."""),

    /**
     * Absolute amount of "reactive electrical energy" (VARh or kVARh) exported (to the grid)
     * during an associated time "interval", specified by a Metervalues ReadingContext,
     * and applicable interval duration configuration values (in seconds) for
     * "ClockAlignedDataInterval" and "MeterValueSampleInterval".
     */
    ENERGY_REACTIVE_EXPORT_INTERVAL("Energy.Reactive.Export.Interval", """
        Absolute amount of "reactive electrical energy" (VARh or kVARh) exported (to the grid) during an associated time "interval", specified by a Metervalues ReadingContext, and applicable interval duration configuration values (in seconds) for "ClockAlignedDataInterval" and "MeterValueSampleInterval"."""),

    /**
     * Absolute amount of "reactive electrical energy" (VARh or kVARh) imported (from the grid supply)
     * during an associated time "interval", specified by a Metervalues ReadingContext,
     * and applicable interval duration configuration values (in seconds) for
     * "ClockAlignedDataInterval" and "MeterValueSampleInterval"
     */
    ENERGY_REACTIVE_IMPORT_INTERVAL("Energy.Reactive.Import.Interval", """
        Absolute amount of "reactive electrical energy" (VARh or kVARh) imported (from the grid supply) during an associated time "interval", specified by a Metervalues ReadingContext, and applicable interval duration configuration values (in seconds) for "ClockAlignedDataInterval" and "MeterValueSampleInterval"."""),


    /**
     * Instantaneous reading of powerline frequency. NOTE: OCPP 1.6 does not have a UnitOfMeasure for frequency, the UnitOfMeasure for any SampledValue with measurand: Frequency is Hertz.
     */
    FREQUENCY("Frequency", """
        Instantaneous reading of powerline frequency. NOTE: OCPP 1.6 does not have a UnitOfMeasure for frequency, the UnitOfMeasure for any SampledValue with measurand: Frequency is Hertz."""),


    /**
     * Instantaneous active power exported by EV. (W or kW)
     */
    POWER_ACTIVE_EXPORT("Power.Active.Export", "Instantaneous active power exported by EV. (W or kW)"),

    /**
     * Instantaneous active power imported by EV. (W or kW)
     */
    POWER_ACTIVE_IMPORT("Power.Active.Import", "Instantaneous active power imported by EV. (W or kW)"),

    /**
     * Instantaneous power factor of total energy flow
     */
    POWER_FACTOR("Power.Factor", "Instantaneous power factor of total energy flow"),

    /**
     * Maximum power offered to EV
     */
    POWER_OFFERED("Power.Offered", "Maximum power offered to EV"),

    /**
     * Instantaneous reactive power exported by EV. (var or kvar)
     */
    POWER_REACTIVE_EXPORT("Power.Reactive.Export", "Instantaneous reactive power exported by EV. (var or kvar)"),

    /**
     * Instantaneous reactive power imported by EV. (var or kvar)
     */
    POWER_REACTIVE_IMPORT("Power.Reactive.Import", "Instantaneous reactive power imported by EV. (var or kvar)"),

    /**
     * Fan speed in RPM
     */
    RPM("RPM", "Fan speed in RPM"),

    /**
     * State of charge of charging vehicle in percentage
     */
    SOC("SoC", "State of charge of charging vehicle in percentage"),

    /**
     * Temperature reading inside Charge Point.
     */
    TEMPERATURE("Temperature", "Temperature reading inside Charge Point."),

    /**
     * Instantaneous AC RMS supply voltage
     */
    VOLTAGE("Voltage", "Instantaneous AC RMS supply voltage");

    private final String value;
    private final String description;

    Measurand(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
