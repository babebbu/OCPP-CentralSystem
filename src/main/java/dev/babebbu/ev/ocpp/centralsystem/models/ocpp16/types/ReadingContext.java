package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum ReadingContext {

    /**
     * Value taken at start of interruption.
     */
    INTERRUPTION_BEGIN("Interruption.Begin", "Value taken at start of interruption."),

    /**
     * Value taken when resuming after interruption.
     */
    INTERRUPTION_END("Interruption.End", "Value taken when resuming after interruption."),

    /**
     * Value for any other situations.
     */
    OTHER("Other", "Value for any other situations."),

    /**
     * Value taken at clock aligned interval.
     */
    SAMPLE_CLOCK("Sample.Clock", "Value taken at clock aligned interval."),

    /**
     * Value taken as periodic sample relative to start time of transaction.
     */
    SAMPLE_PERIOD("Sample.Periodic", "Value taken as periodic sample relative to start time of transaction."),

    /**
     * Value taken at start of transaction.
     */
    TRANSACTION_BEGIN("Transaction.Begin", "Value taken at start of transaction."),

    /**
     * Value taken at end of transaction.
     */
    TRANSACTION_END("Transaction.End", "Value taken at end of transaction."),

    /**
     * Value taken in response to a TriggerMessage.req
     */
    TRIGGER("Trigger", "Value taken in response to a TriggerMessage.req");

    private final String value;
    private final String description;

    ReadingContext(String value, String description) {
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
        return this.value;
    }

}
