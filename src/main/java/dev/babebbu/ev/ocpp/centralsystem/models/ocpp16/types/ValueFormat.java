package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum ValueFormat {
    /**
     * Data is to be interpreted as integer/decimal numeric data.
     */
    Raw("Raw", "Data is to be interpreted as integer/decimal numeric data."),

    /**
     * Data is represented as a signed binary data block, encoded as hex data.
     */
    SignedData("Signed", "Data is represented as a signed binary data block, encoded as hex data.");

    private final String value;
    private final String description;

    ValueFormat(String value, String description) {
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
