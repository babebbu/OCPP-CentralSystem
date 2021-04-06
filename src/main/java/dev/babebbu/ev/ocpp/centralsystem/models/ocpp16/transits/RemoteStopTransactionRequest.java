package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class RemoteStopTransactionRequest {
    /**
     * Required. The identifier of the transaction which Charge Point is requested to stop.
     */
    @NonNull
    private int transactionId;
}
