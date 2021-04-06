package dev.babebbu.ev.ocpp.centralsystem.models.messages;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.MessageType;

public class CallResult extends AbstractOcppMessage {

    private final int PAYLOAD = 2;

    public CallResult() {
        this(null, null);
    }

    public CallResult(String uniqueId, Object payload) {
        super(MessageType.CALL_RESULT, uniqueId);
        getProperties().add(payload);
    }

    public void setPayload(Object payload) {
        getProperties().set(PAYLOAD, payload);
    }

    public Object getPayload() {
        return getProperties().get(PAYLOAD).toString();
    }

}
