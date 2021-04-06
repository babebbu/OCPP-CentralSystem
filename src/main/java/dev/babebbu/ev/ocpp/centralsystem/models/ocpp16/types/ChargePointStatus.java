package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum ChargePointStatus implements EnumValue {
    /**
     * When a Connector becomes available for a new user.
     * (Operative)
     */
    AVAILABLE("Available", "(Operative) A connector becomes available for a new user."),

    /**
     * When a Connector becomes no longer available for a new user but there is no ongoing Transaction (yet).
     * Typically a Connector is in preparing state when a user presents a tag,
     * inserts a cable or a vehicle occupies the parking bay.
     * (Operative)
     */
    PREPARING("Preparing", """
        (Operative) A connector becomes no longer available for a new user but there is no ongoing Transaction (yet). 
        Typically a Connector is in preparing state when a user presents a tag, 
        inserts a cable or a vehicle occupies the parking bay."""),

    /**
     * When the contactor of a Connector closes, allowing the vehicle to charge
     * (Operative)
     */
    CHARGING("Charging", "(Operative) The contactor of a Connector closes, allowing the vehicle to charge."),

    /**
     * When the EV is connected to the EVSE but the EVSE is not offering energy to the EV,
     * e.g. due to a smart charging restriction, local supply power constraints,
     * or as the result of StartTransaction.conf indicating that charging is not allowed etc.
     * (Operative)
     */
    SUSPENDED_EVSE("SuspendedEVSE", """
        (Operative) When the EV is connected to the EVSE but the EVSE is not offering energy to the EV, 
        e.g. due to a smart charging restriction, local supply power constraints, 
        or as the result of StartTransaction.conf indicating that charging is not allowed etc."""),

    /**
     * When the EV is connected to the EVSE and the EVSE is offering energy but the EV is not taking any energy. (Operative)
     */
    SUSPENDED_EV("SuspendedEV", "(Operative) The EV is connected to the EVSE and the EVSE is offering energy but the EV is not taking any energy."),

    /**
     * When a Transaction has stopped at a Connector, but the Connector is not yet available for a new user, e.g. the cable has not been removed or the vehicle has not left the parking bay
     * (Operative)
     */
    FINISHING("Finishing", """
        (Operative) A transaction has stopped at a Connector, 
        but the Connector is not yet available for a new user, 
        e.g. the cable has not been removed or the vehicle has not left the parking bay"""),

    /**
     *
     When a Connector becomes reserved as a result of a Reserve Now command
     (Operative)
     */
    RESERVED("Reserved", "(Operative) A connector becomes reserved as a result of a Reserve Now command."),

    /**
     * When a Connector becomes unavailable as the result of a Change Availability command or an event upon which
     * the Charge Point transitions to unavailable at its discretion. Upon receipt of a Change Availability command,
     * the status MAY change immediately or the change MAY be scheduled. When scheduled,
     * the Status Notification shall be send when the availability change becomes effective
     * (Inoperative)
     */
    UNAVAILABLE("Unavailable", """
        (Inoperative) A connector becomes unavailable as the result of a Change Availability command or an event upon which 
        the Charge Point transitions to unavailable at its discretion. Upon receipt of a Change Availability command, 
        the status MAY change immediately or the change MAY be scheduled. When scheduled, 
        the Status Notification shall be send when the availability change becomes effective."""),

    /**
     * When a Charge Point or connector has reported an error and is not available for energy delivery.
     * (Inoperative).
     */
    FAULTED("Faulted", "(Inoperative) A charge point or connector has reported an error and is not available for energy delivery.");

    private final String value;
    private final String description;

    ChargePointStatus(String value, String description) {
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
