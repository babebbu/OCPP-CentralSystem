package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum ClearCacheStatus {
    /**
     * Command has been executed.
     */
    ACCEPTED("Accepted", "Command has been executed."),

    /**
     * Command has not been executed.
     */
    REJECTED("Rejected", "Command has not been executed.");

    private final String value;
    private final String description;

    ClearCacheStatus(String value, String description) {
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
