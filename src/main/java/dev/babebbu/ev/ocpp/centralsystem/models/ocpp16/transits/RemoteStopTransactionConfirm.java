package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.RemoteStartStopStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemoteStopTransactionConfirm {
    /**
     * Required. Status indicating whether Charge Point accepts the request to stop a transaction.
     */
    private RemoteStartStopStatus status;
}
