package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum ResetType {

    HARD("Hard", """
        Restart (all) the hardware, the Charge Point is not required to gracefully stop ongoing transaction. 
        If possible the Charge Point sends a StopTransaction.req for previously ongoing transactions after 
        having restarted and having been accepted by the Central System via a BootNotification.conf. 
        This is a last resort solution for a not correctly functioning Charge Point, 
        by sending a "hard" reset, (queued) information might get lost."""),

    SOFT("Soft", """
        Stop ongoing transactions gracefully and sending StopTransaction.req for every ongoing transaction. 
        It should then restart the application software (if possible, otherwise restart the processor/controller).""");

    private final String value;
    private final String description;

    ResetType(String value, String description) {
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
