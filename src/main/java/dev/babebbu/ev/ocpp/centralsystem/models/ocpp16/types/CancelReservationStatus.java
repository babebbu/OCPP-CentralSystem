package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum CancelReservationStatus {
    /**
     * Reservation for the identifier has been cancelled.
     */
    ACCEPTED("Accepted", "Reservation for the identifier has been cancelled."),

    /**
     * Reservation could not be cancelled, because there is no reservation active for the identifier.
     */
    REJECTED("Rejected", "Reservation could not be cancelled, because there is no reservation active for the identifier.");

    private final String value;
    private final String description;

    CancelReservationStatus(String value, String description) {
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
