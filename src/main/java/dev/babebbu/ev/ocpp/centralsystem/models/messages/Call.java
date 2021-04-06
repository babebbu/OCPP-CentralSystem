package dev.babebbu.ev.ocpp.centralsystem.models.messages;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.MessageType;

public class Call extends AbstractOcppMessage {

    private final int ACTION = 2;
    private final int PAYLOAD = 3;

    public Call() {
        this(null, null);
    }

    public Call(String action, Object payload) {
        super(MessageType.CALL);
        getProperties().add(action);
        getProperties().add(payload);
    }

    public void setAction(String action) {
        getProperties().set(ACTION, action);
    }

    public String getAction() {
        return getProperties().get(ACTION).toString();
    }

    public void setPayload(Object payload) {
        getProperties().set(PAYLOAD, payload);
    }

    public String getPayload() {
        return getProperties().get(PAYLOAD).toString();
    }

}
