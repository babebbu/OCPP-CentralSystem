package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum ChargingRateUnitType {
    /**
     * Watts (power).
     * This is the TOTAL allowed charging power.
     * If used for AC Charging, the phase current should be calculated via:
     *
     *     Current per phase = Power / (Line Voltage * Number of Phases).
     *
     * The "Line Voltage" used in the calculation is not the measured voltage,
     * but the set voltage for the area (hence, 230 of 110 volt).
     * The "Number of Phases" is the numberPhases from the ChargingSchedulePeriod.
     * It is usually more convenient to use this for DC charging.
     * Note that if numberPhases in a ChargingSchedulePeriod is absent, 3 SHALL be assumed.
     */
    Watts("W", "Watts (Power)"),

    /**
     * Amperes (current).
     * The amount of Ampere per phase, not the sum of all phases.
     * It is usually more convenient to use this for AC charging.
     */
    Amp("A", "Amperes (Current)");

    private final String value;
    private final String description;

    ChargingRateUnitType(String value, String description) {
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
