package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum UpdateType {
    /**
     * Indicates that the current Local Authorization List must be updated with the values in this message.
     */
    DIFFERENTIAL("Differential", "Indicates that the current Local Authorization List must be updated with the values in this message."),

    /**
     * Indicates that the current Local Authorization List must be replaced by the values in this message.
     */
    FULL("Full", "Indicates that the current Local Authorization List must be replaced by the values in this message.");

    private final String value;
    private final String description;

    UpdateType(String value, String description) {
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
