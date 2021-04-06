package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum Reason {
    /**
     * The transaction was stopped because of the authorization status in a StartTransaction.conf
     */
    DE_AUTHORIZE("DeAuthorized", "The transaction was stopped because of the authorization status in a StartTransaction.conf"),

    /**
     * Emergency stop button was used.
     */
    EMERGENCY_STOP("EmergencyStop", "Emergency stop button was used."),

    /**
     * disconnecting of cable, vehicle moved away from inductive charge unit.
     */
    EV_DISCONNECTED("EVDisconnected", "Disconnecting of cable, vehicle moved away from inductive charge unit."),

    /**
     * A hard reset command was received.
     */
    HARD_RESET("HardReset", "A hard reset command was received."),

    /**
     * Stopped locally on request of the user at the Charge Point. This is a regular termination of a transaction.
     * Examples: presenting an RFID tag, pressing a button to stop.
     */
    LOCAL("Local", "Stopped locally on request of the user at the Charge Point. This is a regular termination of a transaction."),

    /**
     * Any other reason.
     */
    OTHER("Other", "Any other reason."),

    /**
     * Complete loss of power.
     */
    POWER_LOSS("PowerLoss", "Complete loss of power."),

    /**
     * A locally initiated reset/reboot occurred. (for instance watchdog kicked in)
     */
    REBOOT("Reboot", "A locally initiated reset/reboot occurred. (for instance watchdog kicked in)"),

    /**
     *  Stopped remotely on request of the user. This is a regular termination of a transaction.
     *  Examples: termination using a smartphone app, exceeding a (non local) prepaid credit.
     */
    REMOTE("Remote", "Stopped remotely on request of the user. This is a regular termination of a transaction. "),

    /**
     * A soft reset command was received.
     */
    SOFT_RESET("SoftReset", "A soft reset command was received."),

    /**
     * Central System sent an Unlock Connector command.
     */
    UNLOCK_COMMAND("UnlockCommand", "Central System sent an Unlock Connector command.");

    private final String value;
    private final String description;

    Reason(String value, String description) {
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
