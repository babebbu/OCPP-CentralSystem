package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum ChargingProfileKindType {
    /**
     * Schedule periods are relative to a fixed point in time defined in the schedule.
     */
    ABSOLUTE("Absolute", "Schedule periods are relative to a fixed point in time defined in the schedule."),

    /**
     * The schedule restarts periodically at the first schedule period.
     */
    RECURRING("Recurring", "The schedule restarts periodically at the first schedule period."),

    /**
     * Schedule periods are relative to a situation-specific start point (such as the start of a Transaction) that is determined by the charge point.
     */
    RELATIVE("Relative", "Schedule periods are relative to a situation-specific start point (such as the start of a Transaction) that is determined by the charge point.");

    private final String value;
    private final String description;

    ChargingProfileKindType(String value, String description) {
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
