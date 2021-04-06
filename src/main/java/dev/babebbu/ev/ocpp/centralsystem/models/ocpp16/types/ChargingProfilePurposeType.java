package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum ChargingProfilePurposeType {
    /**
     * Configuration for the maximum power or current available for an entire Charge Point.
     */
    CHARGE_POINT_MAX_PROFILE("ChargePointMaxProfile", "Configuration for the maximum power or current available for an entire Charge Point."),

    /**
     * Default profile *that can be configured in the Charge Point. When a new transaction is started,
     * this profile SHALL be used, unless it was a transaction that was started by a RemoteStartTransaction.req with
     * a ChargeProfile that is accepted by the Charge Point.
     */
    TX_DEFAULT_PROFILE("TxDefaultProfile", """
        Default profile *that can be configured in the Charge Point. When a new transaction is started, 
        this profile SHALL be used, unless it was a transaction that was started by a RemoteStartTransaction.req 
        with a ChargeProfile that is accepted by the Charge Point."""),

    /**
     * Profile with constraints to be imposed by the Charge Point on the current transaction,
     * or on a new transaction when this is started via a RemoteStartTransaction.req with a ChargeProfile.
     * A profile with this purpose SHALL
     * cease to be valid when the transaction terminates.
     */
    TX_PROFILE("TxProfile", """
        Profile with constraints to be imposed by the Charge Point on the current transaction, 
        or on a new transaction when this is started via a RemoteStartTransaction.req with a ChargeProfile. 
        A profile with this purpose SHALL cease to be valid when the transaction terminates.""");

    private final String value;
    private final String description;

    ChargingProfilePurposeType(String value, String description) {
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
