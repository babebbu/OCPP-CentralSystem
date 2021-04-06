package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.IdTagInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StopTransactionConfirm {
    /**
     * Optional. This contains information about authorization status, expiry and parent id.
     * It is optional, because a transaction may have been stopped without an identifier.
     */
    private IdTagInfo idTagInfo;
}
