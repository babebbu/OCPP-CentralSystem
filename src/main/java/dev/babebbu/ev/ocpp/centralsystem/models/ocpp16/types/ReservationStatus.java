package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum ReservationStatus {
    /**
     * Charge point is accepted by Central System.
     */
    ACCEPTED("Accepted", "Charge point is accepted by Central System."),

    /**
     * Reservation has not been made, because connectors or specified connector are in a faulted state.
     */
    FAULTED("Faulted", "Reservation has not been made, because connectors or specified connector are in a faulted state."),

    /**
     * Reservation has not been made. All connectors or the specified connector are occupied.
     */
    OCCUPIED("Occupied", "Reservation has not been made. All connectors or the specified connector are occupied."),

    /**
     * Reservation has not been made. Charge Point is not configured to accept reservations.
     */
    REJECTED("Rejected", "Reservation has not been made. Charge Point is not configured to accept reservations."),

    /**
     * Reservation has not been made, because connectors or specified connector are in an unavailable state.
     */
    UNAVAILABLE("Unavailable", "Reservation has not been made, because connectors or specified connector are in an unavailable state.");

    private final String value;
    private final String description;

    ReservationStatus(String value, String description) {
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
