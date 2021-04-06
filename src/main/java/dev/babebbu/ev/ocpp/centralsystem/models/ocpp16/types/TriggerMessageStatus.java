package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum TriggerMessageStatus {
    ACCEPTED("Accepted", "Requested notification will be sent."),
    REJECTED("Rejected", "Requested notification will not be sent."),
    NOT_IMPLEMENTED("NotImplemented", "Requested notification cannot be sent because it is either not implemented or unknown.");

    private final String value;
    private final String description;

    TriggerMessageStatus(String value, String description) {
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
