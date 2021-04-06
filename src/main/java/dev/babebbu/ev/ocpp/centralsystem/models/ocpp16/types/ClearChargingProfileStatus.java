package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum ClearChargingProfileStatus {
    /**
     * Request has been accepted and will be executed.
     */
    ACCEPTED("Accepted", "Request has been accepted and will be executed."),

    /**
     * No Charging Profile(s) were found matching the request.
     */
    UNKNOWN("Unknown", "No Charging Profile(s) were found matching the request.");

    private final String value;
    private final String description;

    ClearChargingProfileStatus(String value, String description) {
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
