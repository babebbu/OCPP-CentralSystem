package dev.babebbu.ev.ocpp.centralsystem.models.messages;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.babebbu.ev.ocpp.centralsystem.utils.ObjectMapperFactory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public abstract class AbstractOcppMessage {

    private final List<Object> properties;

    private static final int MESSAGE_TYPE = 0;
    protected static final int UNIQUE_ID = 1;

    public AbstractOcppMessage(int messageType) {
        this(messageType, UUID.randomUUID().toString());
    }

    public AbstractOcppMessage(int messageType, String uniqueId) {
        properties = new ArrayList<>() {{
            add(messageType);
            add(uniqueId);
        }};
    }

    public List<Object> getProperties() {
        return properties;
    }

    protected void setMessageType(int messageType) {
        getProperties().set(MESSAGE_TYPE, messageType);
    }

    public int getMessageType() {
        return (int) getProperties().get(MESSAGE_TYPE);
    }

    protected void setUniqueId(UUID uniqueId) {
        getProperties().set(UNIQUE_ID, uniqueId);
    }

    public String getUniqueId() {
        return getProperties().get(UNIQUE_ID).toString();
    }

    public String toJsonString() throws JsonProcessingException {
        return ObjectMapperFactory.getObjectMapper().writeValueAsString(properties);
    }

}
