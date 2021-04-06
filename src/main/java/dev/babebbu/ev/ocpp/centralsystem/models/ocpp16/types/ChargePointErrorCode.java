package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum ChargePointErrorCode implements EnumValue {
    /**
     * Failure to lock or unlock connector.
     */
    CONNECTOR_LOCK_FAILURE("ConnectorLockFailure", "Failure to lock or unlock connector."),

    /**
     *
     Communication failure with the vehicle, might be Mode 3 or other communication protocol problem.
     This is not a real error in the sense that the Charge Point doesn’t need to go to the faulted state.
     Instead, it should go to the SuspendedEVSE state.
     */
    EV_COMMUNICATION_ERROR("EVCommunicationError", "Communication failure with the vehicle, might be Mode 3 or other communication protocol problem. This is not a real error in the sense that the Charge Point doesn’t need to go to the faulted state. Instead, it should go to the SuspendedEVSE state."),

    /**
     * Ground fault circuit interrupter has been activated.
     */
    GROUND_FAILURE("GroundFailure", "Ground fault circuit interrupter has been activated."),

    /**
     * Temperature inside Charge Point is too high.
     */
    HIGH_TEMPERATURE("HighTemperature", "Temperature inside Charge Point is too high."),

    /**
     * Error in internal hard- or software component.
     */
    INTERNAL_ERROR("InternalError", "Error in internal hard- or software component."),

    /**
     * The authorization information received from the Central System is in conflict with the LocalAuthorizationList.
     */
    LOCAL_LIST_CONFLICT("LocalListConflict", "The authorization information received from the Central System is in conflict with the LocalAuthorizationList."),

    /**
     * No error to report.
     */
    NO_ERROR("NoError", "No error to report."),

    /**
     * Other type of error. More information in vendorErrorCode.
     */
    OTHER_ERROR("OtherError", "Other type of error. More information in vendorErrorCode."),

    /**
     * Over current protection device has tripped.
     */
    OVER_CURRENT_FAILURE("OverCurrentFailure", "Over current protection device has tripped."),

    /**
     * Voltage has risen above an acceptable level.
     */
    OVER_VOLTAGE("OverVoltage", "Voltage has risen above an acceptable level."),

    /**
     * Failure to read electrical/energy/power meter.
     */
    POWER_METER_FAILURE("PowerMeterFailure", "Failure to read electrical/energy/power meter."),

    /**
     * Failure to control power switch.
     */
    POWER_SWITCH_FAILURE("PowerSwitchFailure", "Failure to control power switch."),

    /**
     * Failure with idTag reader.
     */
    READER_FAILURE("ReaderFailure", "Failure with idTag reader."),

    /**
     * Unable to perform a reset.
     */
    RESET_FAILURE("ResetFailure", "Unable to perform a reset."),

    /**
     * Voltage has dropped below an acceptable level.
     */
    UNDER_VOLTAGE("UnderVoltage", "Voltage has dropped below an acceptable level."),

    /**
     * Wireless communication device reports a weak signal.
     */
    WEAK_SIGNAL("WeakSignal", "Wireless communication device reports a weak signal.");

    private final String value;
    private final String description;

    ChargePointErrorCode(String value, String description) {
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
