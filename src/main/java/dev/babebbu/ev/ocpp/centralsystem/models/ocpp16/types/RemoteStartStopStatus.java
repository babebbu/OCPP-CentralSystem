package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum RemoteStartStopStatus {
    ACCEPTED("Accepted", "Command will be executed"),
    REJECTED("Rejected", "Command will not be executed");

    private final String value;
    private final String description;

    RemoteStartStopStatus(String value, String description) {
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
