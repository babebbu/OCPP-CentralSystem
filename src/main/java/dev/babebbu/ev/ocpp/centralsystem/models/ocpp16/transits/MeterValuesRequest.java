package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.MeterValue;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeterValuesRequest {
    /**
     * Required. This contains a number (>0) designating a connector of the Charge Point.‘0’ (zero) is used to designate the main power meter.
     */
    @NonNull
    private int connectorId;

    /**
     * Optional. The transaction to which these meter samples are related.
     */
    private int transactionId;

    /**
     * Required. The sampled meter values with timestamps.
     */
    @NonNull
    private MeterValue meterValue;
}
