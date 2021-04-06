package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum UnitOfMeasure {
    WATT_HOURS("Wh", "Watt-hours (energy). Default."),
    KILOWATT_HOURS("kWh", "KiloWatt-hours (energy)."),
    VAR_HOURS("varh", "Var-hours (reactive energy)."),
    KILO_VAR_HOURS("kvarh", "Kilovar-hours (reactive energy)."),
    WATTS("W", "Watts (Power)."),
    KILO_WATTS("kW", "Kilowatts (Power)."),
    VOLT_AMPERE("VA", "Volt-Ampere (Apparent Power)."),
    KILO_VOLT_AMPERE("kVA", "KiloVolt-Ampere (Apparent Power)."),
    VAR("var", "Vars (reactive power)."),
    KILO_VAR("kvar", "Vars (reactive power).)"),
    AMPERE("A", "Ampere (Current)."),
    VOLTAGE("V", "Voltage (r.m.s. AC)"),
    CELSIUS("Celsius" , "Degrees (Temperature)."),
    FAHRENHEIT("Fahrenheit", "Degrees (Temperature).)"),
    KELVIN("K", "Degrees Kelvin (Temperature)."),
    PERCENT("Percent", "Percentage.");

    private final String value;
    private final String description;

    UnitOfMeasure(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
