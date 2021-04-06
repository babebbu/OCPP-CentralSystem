package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum AvailabilityStatus {
    /**
     * Request has been accepted and will be executed.
     */
    ACCEPTED("Accepted", "Request has been accepted and will be executed."),

    /**
     * Request has not been accepted and will not be executed.
     */
    REJECTED("Rejected", "Request has not been accepted and will not be executed."),

    /**
     * Request has been accepted and will be executed when transaction(s) in progress have finished.
     */
    SCHEDULED("Scheduled", "Request has been accepted and will be executed when transaction(s) in progress have finished.");

    private final String value;
    private final String description;

    AvailabilityStatus(String value, String description) {
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
