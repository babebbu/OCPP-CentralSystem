package dev.babebbu.ev.ocpp.centralsystem.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.babebbu.ev.ocpp.centralsystem.InMemoryDatabase;
import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.MessageType;
import dev.babebbu.ev.ocpp.centralsystem.models.messages.CallResult;
import dev.babebbu.ev.ocpp.centralsystem.utils.ObjectMapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;
import java.util.Objects;

@Component
public class OcppWebSocketHandler extends TextWebSocketHandler {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final ObjectMapper objectMapper;

    public OcppWebSocketHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOG.debug("Connected ... " + session.getId());
        InMemoryDatabase.sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        final int MESSAGE_TYPE = 0;
        final int UNIQUE_ID = 1;
        Object[] message = ObjectMapperFactory.getObjectMapper().readValue(textMessage.getPayload(), Object[].class);

        switch ((int) message[MESSAGE_TYPE]) {
            case MessageType.CALL -> handleCall(session, message[UNIQUE_ID].toString(), message);
            case MessageType.CALL_RESULT -> handleCallResult(session, message);
            case MessageType.CALL_ERROR -> handleCallError(session, message);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        LOG.info(String.format("Session %s closed because of %s", session.getId(), status.getReason()));
        InMemoryDatabase.getSessions().remove(session);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
        LOG.error("error occured at sender " + session, throwable);
    }

    /**
     *  --------------                     --------------
     *  |   Client   | ==========[Call]==> |   Server   |
     *  --------------                     --------------
     *  Server is accepting Call from client and Call must be handle
     */
    public void handleCall(WebSocketSession session, String uniqueId, Object[] call) throws IOException, InterruptedException {

        String chargePointId = session.getAttributes().get("chargePointId").toString();

        final int ACTION = 2;
        final int PAYLOAD = 3;

        String action = call[ACTION].toString();
        String payload = ObjectMapperFactory.getObjectMapper().writeValueAsString(call[PAYLOAD]);

        String id = session.getId();
        LOG.debug("[CALL] Action = {}, Payload = {}", action, payload);

        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8080/ocpp/v1.6/ChargePoints/" + action))
            .timeout(Duration.ofMinutes(1))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(payload))
            .build();

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (Objects.requireNonNull(HttpStatus.resolve(httpResponse.statusCode())).is2xxSuccessful()) {
            session.sendMessage(
                new TextMessage(
                    new CallResult(uniqueId, objectMapper.readValue(httpResponse.body(), Map.class)).toJsonString()
                )
            );
        }
    }
    
    /**        
     *  --------------                     --------------
     *  |   Client   | <==[Call]========== |   Server   |
     *  --------------                     --------------
     *  --------------                     --------------
     *  |   Client   | ====[CallResult]==> |   Server   |
     *  --------------                     --------------
     *  Server is accepting Call from client and Call must be handle  
     */                                                              
    public void handleCallResult(WebSocketSession session, Object[] callResult) throws IOException {
        LOG.debug(objectMapper.writeValueAsString(callResult[2]));
    }

    /**
     *  --------------                     --------------
     *  |   Client   | <==[Call]========== |   Server   |
     *  --------------                     --------------
     *  --------------                     --------------
     *  |   Client   | =====[CallError]==> |   Server   |
     *  --------------                     --------------
     *  Server is accepting Call from client and Call must be handle
     */
    public void handleCallError(WebSocketSession session, Object[] callError) {

    }

}
