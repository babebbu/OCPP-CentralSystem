package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum GetCompositeScheduleStatus {
    /**
     * Request has been accepted and will be executed.
     */
    ACCEPTED("Accepted", "Request has been accepted and will be executed."),

    /**
     * Request has not been accepted and will not be executed.
     */
    REJECTED("Rejected", "Request has not been accepted and will not be executed.");

    private final String value;
    private final String description;

    GetCompositeScheduleStatus(String value, String description) {
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
