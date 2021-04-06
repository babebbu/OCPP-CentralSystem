package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum DiagnosticsStatus {
    /**
     * Charge Point is not performing diagnostics related tasks.
     * Status Idle SHALL only be used as in a DiagnosticsStatusNotification.req that was triggered by a TriggerMessage.req
     */
    IDLE("Idle", "Charge Point is not performing diagnostics related tasks."),

    /**
     * Diagnostics information has been uploaded.
     */
    UPLOADED("Uploaded", "Diagnostics information has been uploaded."),

    /**
     * Uploading of diagnostics failed.
     */
    UPLOAD_FAILED("Upload_Failed", "Uploading of diagnostics failed."),

    /**
     * File is being uploaded.
     */
    UPLOADING("Uploading", "File is being uploaded.");

    private final String value;
    private final String description;

    DiagnosticsStatus(String value, String description) {
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
