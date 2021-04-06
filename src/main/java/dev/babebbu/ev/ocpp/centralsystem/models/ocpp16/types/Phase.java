package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

public enum Phase {
    L1("L1", "Measured on L1"),
    L2("L2", "Measured on L2"),
    L3("L3", "Measured on L3"),
    N("N", "Measured on Neutral\n"),
    L1_N("L1-N", "Measured on L1 with respect to Neutral conductor\n"),
    L2_N("L2-N", "Measured on L2 with respect to Neutral conductor"),
    L3_N("L3-N" ,"Measured on L3 with respect to Neutral conductor\n"),
    L1_L2("L1-L2", "Measured between L1 and L2"),
    L2_L3("L2-L3", "Measured between L2 and L3"),
    L3_L1("L3-L1", "Measured between L3 and L1");

    private final String value;
    private final String description;

    Phase(String value, String description) {
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
