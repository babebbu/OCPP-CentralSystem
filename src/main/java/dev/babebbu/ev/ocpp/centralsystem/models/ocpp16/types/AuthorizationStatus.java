package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum AuthorizationStatus {
    /**
     * Identifier is allowed for charging.
     */
    ACCEPTED("Accepted","Identifier is allowed for charging."),

    /**
     * Identifier has been blocked. Not allowed for charging.
     */
    BLOCKED("Blocked", "Identifier has been blocked. Not allowed for charging."),

    /**
     * Identifier has expired. Not allowed for charging.
     */
    EXPIRED("Expired", "Identifier has expired. Not allowed for charging."),

    /**
     * Identifier is unknown. Not allowed for charging.
     */
    INVALID("Invalid", "Identifier is unknown. Not allowed for charging."),

    /**
     * Identifier is already involved in another transaction and multiple transactions are not allowed.
     * (Only relevant for a StartTransaction.req.)
     */
    CONCURRENT_TX("ConcurrentTx", "Identifier is already involved in another transaction and multiple transactions are not allowed.");

    private final String value;
    private final String description;

    AuthorizationStatus(String value, String description) {
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
