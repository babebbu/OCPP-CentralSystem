package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum DataTransferStatus {
    /**
     * Message has been accepted and the contained request is accepted.
     */
    ACCEPTED("Accepted", "Message has been accepted and the contained request is accepted."),

    /**
     * Message has been accepted but the contained request is rejected.
     */
    REJECTED("Rejected", "Message has been accepted but the contained request is rejected."),

    /**
     * Message could not be interpreted due to unknown messageId string.
     */
    UNKNOWN_MESSAGE_ID("UnknownMessageId", "Message could not be interpreted due to unknown messageId string."),

    /**
     * Message could not be interpreted due to unknown vendorId string.
     */
    UNKNOWN_VENDOR_ID("UnknownVendorId", "Message could not be interpreted due to unknown vendorId string.");

    private final String value;
    private final String description;

    DataTransferStatus(String value, String description) {
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
