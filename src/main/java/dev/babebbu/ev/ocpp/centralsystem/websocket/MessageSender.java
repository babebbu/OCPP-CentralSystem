package dev.babebbu.ev.ocpp.centralsystem.websocket;

import dev.babebbu.ev.ocpp.centralsystem.InMemoryDatabase;
import dev.babebbu.ev.ocpp.centralsystem.models.messages.Call;
import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits.CallAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

public class MessageSender {

    private static final Logger LOG = LoggerFactory.getLogger(MessageSender.class);

    public static void sendMessage(WebSocketSession session, CallAction message) throws IOException {
        if (session.isOpen()) {
            session.sendMessage(new TextMessage(new Call(message.getAction(), message).toJsonString()));
        }
    }

    public static void broadcastMessage(CallAction message) {
        InMemoryDatabase.getSessions().parallelStream().forEach(session -> {
            try {
                MessageSender.sendMessage(session, message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
