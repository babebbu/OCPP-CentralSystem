package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum RegistrationStatus {
    /**
     * Charge point is accepted by Central System.
     */
    ACCEPTED("Accepted", "Charge point is accepted by Central System."),

    /**
     * Central System is not yet ready to accept the Charge Point. Central System may send messages to retrieve information or prepare the Charge Point.
     */
    PENDING("Pending", "Central System is not yet ready to accept the Charge Point. Central System may send messages to retrieve information or prepare the Charge Point."),

    /**
     * Charge point is not accepted by Central System. This may happen when the Charge Point id is not known by Central System.
     */
    REJECTED("Rejected", "Charge point is not accepted by Central System. This may happen when the Charge Point id is not known by Central System.");

    private final String value;
    private final String description;

    RegistrationStatus(String value, String description) {
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
