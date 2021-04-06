package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.DataTransferStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class DataTransferConfirm {
    /**
     * Required. This indicates the success or failure of the data transfer.
     */
    @NonNull
    private DataTransferStatus status;

    /**
     * Optional. Data in response to request.
     */
    private String data;
}
