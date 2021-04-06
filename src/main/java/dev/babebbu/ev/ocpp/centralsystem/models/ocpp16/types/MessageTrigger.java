package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum MessageTrigger {
    /**
     * To trigger a BootNotification request
     */
    BOOT_NOTIFICATION("BootNotification", "Trigger a BootNotification request"),

    /**
     * To trigger a DiagnosticsStatusNotification request
     */
    DIAGNOSTICS_STATUS_NOTIFICATION("DiagnosticsStatusNotification", "Trigger a DiagnosticsStatusNotification request"),

    /**
     * To trigger a FirmwareStatusNotification request
     */
    FIRMWARE_STATUS_NOTIFICATION("FirmwareStatusNotification", "Trigger a FirmwareStatusNotification request"),

    /**
     * To trigger a Heartbeat request
     */
    HEARTBEAT("Heartbeat", "Trigger a Heartbeat request"),

    /**
     * To trigger a StatusNotification request
     */
    STATUS_NOTIFICATION("StatusNotification", "Trigger a StatusNotification request");

    private final String value;
    private final String description;

    MessageTrigger(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
