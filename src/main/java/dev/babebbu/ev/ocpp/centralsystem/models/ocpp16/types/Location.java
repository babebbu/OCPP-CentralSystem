package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum Location {
    /**
     * Measurement inside body of Charge Point (e.g. Temperature)
     */
    BODY("Body", "Measurement inside body of Charge Point (e.g. Temperature)"),

    /**
     * Measurement taken from cable between EV and Charge Point
     */
    CABLE("Cable", "Measurement taken from cable between EV and Charge Point"),

    /**
     * Measurement taken by EV
     */
    EV("EV", "Measurement taken by EV"),

    /**
     * Measurement at network (“grid”) inlet connection
     */
    INLET("Inlet", "Measurement at network (“grid”) inlet connection"),

    /**
     * Measurement at a Connector. Default value
     */
    OUTLET("Outlet", "Measurement at a Connector. Default value");

    private final String value;
    private final String description;

    Location(String value, String description) {
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
