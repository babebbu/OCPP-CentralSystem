package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum RecurrencyKindType {
    /**
     * The schedule restarts every 24 hours, at the same time as in the startSchedule.
     */
    DAILY("Daily", "The schedule restarts every 24 hours, at the same time as in the startSchedule."),

    /**
     * The schedule restarts every 7 days, at the same time and day-of-the-week as in the startSchedule.
     */
    WEEKLY("Weekly", "The schedule restarts every 7 days, at the same time and day-of-the-week as in the startSchedule.");

    private final String value;
    private final String description;

    RecurrencyKindType(String value, String description) {
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
