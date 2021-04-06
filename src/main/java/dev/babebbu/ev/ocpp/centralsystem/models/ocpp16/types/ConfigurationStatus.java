package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum ConfigurationStatus {
    /**
     * Configuration key is supported and setting has been changed.
     */
    ACCEPTED("Accepted", "Configuration key is supported and setting has been changed."),

    /**
     * Configuration key is supported, but setting could not be changed.
     */
    REJECTED("Rejected", "Configuration key is supported, but setting could not be changed."),

    /**
     * Configuration key is supported and setting has been changed, but change will be available after reboot (Charge Point will not reboot itself)
     */
    REBOOT_REQUIRED("RebootRequired", "Configuration key is supported and setting has been changed, but change will be available after reboot (Charge Point will not reboot itself)"),

    /**
     * Configuration key is not supported.
     */
    NOT_SUPPORTED("Not Supported", "Configuration key is not supported.");

    private final String value;
    private final String description;

    ConfigurationStatus(String value, String description) {
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
