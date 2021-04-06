package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.MessageTrigger;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class TriggerMessageRequest {
    /**
     * Required.
     */
    @NonNull
    private MessageTrigger requestedMessage;

    /**
     * Optional. Only filled in when request applies to a specific connector.
     */
    private int connectorId;
}
