package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.RemoteStartStopStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class RemoteStartTransactionConfirm {
    /**
     * Required. Status indicating whether Charge Point accepts the request to start a transaction.
     */
    @NonNull
    private RemoteStartStopStatus status;
}
