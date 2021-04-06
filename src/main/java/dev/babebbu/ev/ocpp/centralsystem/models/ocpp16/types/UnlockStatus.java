package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum UnlockStatus {

    /**
     *
     Connector has successfully been unlocked.
     */
    UNLOCKED("Unlocked", "Connector has successfully been unlocked."),

    /**
     * Failed to unlock the connector: The Charge Point has tried to unlock the connector and has detected that the connector is still locked or the unlock mechanism failed.
     */
    UNLOCK_FAILED("UnlockFailed", """
        Failed to unlock the connector: The Charge Point has tried to unlock the connector and has detected that the connector is still locked or the unlock mechanism failed."""),

    /**
     * Charge Point has no connector lock, or `connectorId` is unknown
     */
    NOT_SUPPORTED("NotSupported", "Charge Point has no connector lock, or `connectorId` is unknown");

    private final String value;
    private final String description;

    UnlockStatus(String value, String description) {
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
