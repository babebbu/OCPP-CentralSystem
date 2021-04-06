package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum UpdateStatus {
    /**
     * Local Authorization List successfully updated.
     */
    ACCEPTED("Accepted", "Local Authorization List successfully updated."),

    /**
     * Failed to update the Local Authorization List.
     */
    FAILED("Failed", "Failed to update the Local Authorization List."),

    /**
     * Update of Local Authorization List is not supported by Charge Point.
     */
    NOT_SUPPORTED("NotSupported", "Update of Local Authorization List is not supported by Charge Point."),

    /**
     * Version number in the request for a differential update is less or equal then version number of current list.
     */
    VERSION_MISMATCH("VersionMismatch", "Version number in the request for a differential update is less or equal then version number of current list.");


    private final String value;
    private final String description;

    UpdateStatus(String value, String description) {
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
