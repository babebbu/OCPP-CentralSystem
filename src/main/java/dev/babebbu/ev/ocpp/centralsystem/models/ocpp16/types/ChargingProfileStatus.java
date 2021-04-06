package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum ChargingProfileStatus {
    /**
     * Request has been accepted and will be executed.
     */
    ACCEPTED("Accepted", "Request has been accepted and will be executed."),

    /**
     * Request has not been accepted and will not be executed.
     */
    REJECTED("Rejected", "Request has not been accepted and will not be executed."),

    /**
     * Charge Point indicates that the request is not supported.
     */
    NOT_SUPPORTED("NotSupported", "Charge Point indicates that the request is not supported.");

    private final String value;
    private final String description;

    ChargingProfileStatus(String value, String description) {
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
