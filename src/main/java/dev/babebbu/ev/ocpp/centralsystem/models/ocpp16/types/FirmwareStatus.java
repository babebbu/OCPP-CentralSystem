package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum FirmwareStatus {
    /**
     * New firmware has been downloaded by Charge Point.
     */
    DOWNLOADED("Downloaded", "New firmware has been downloaded by Charge Point."),

    /**
     * Charge point failed to download firmware.
     */
    DOWNLOAD_FAILED("DownloadFailed", "Charge point failed to download firmware."),

    /**
     * Firmware is being downloaded.
     */
    DOWNLOADING("Downloading", "Firmware is being downloaded."),

    /**
     * Charge Point is not performing firmware update related tasks.
     * Status Idle SHALL only be used as in a FirmwareStatusNotification.req that was triggered by a TriggerMessage.req
     */
    IDLE("Idle", "Charge Point is not performing firmware update related tasks."),

    /**
     * Installation of new firmware has failed.
     */
    INSTALLATION_FAILED("InstallationFailed", "Installation of new firmware has failed."),

    /**
     * Firmware is being installed.
     */
    INSTALLING("Installing", "Firmware is being installed."),

    /**
     * New firmware has successfully been installed in charge point.
     */
    INSTALL("Install", "New firmware has successfully been installed in charge point.");

    private final String value;
    private final String description;

    FirmwareStatus(String value, String description) {
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
