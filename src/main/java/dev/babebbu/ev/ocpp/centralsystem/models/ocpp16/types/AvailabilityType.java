package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum AvailabilityType {
    /**
     * Charge point is not available for charging.
     */
    Inoperative("Inoperative", "Charge point is not available for charging."),

    /**
     * Charge point is available for charging.
     */
    Operative("Operative", "Charge point is available for charging.");

    private final String value;
    private final String description;

    AvailabilityType(String value, String description) {
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
