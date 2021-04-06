package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.MeterValue;
import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.Reason;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StopTransactionRequest {
    /**
     * Optional. This contains the identifier which requested to stop the charging.
     * It is optional because a Charge Point may terminate charging without the presence of an idTag,
     * e.g. in case of a reset. A Charge Point SHALL send the idTag if known.
     */
    private String idTag;

    /**
     * Required. This contains the meter value in Wh for the connector at end of the transaction.
     */
    @NonNull
    private int meterStop;

    /**
     * Required. This contains the date and time on which the transaction is stopped.
     */
    @NonNull
    private String dateTime;

    /**
     * Required. This contains the transaction-id as received by the StartTransaction.conf.
     */
    @NonNull
    private int transactionId;

    /**
     * Optional. This contains the reason why the transaction was stopped.
     * MAY only be omitted when the {@link Reason} is "Local".
     */
    private Reason reason;

    /**
     * Optional. This contains transaction usage details relevant for billing purposes.
     */
    private MeterValue transactionData;

    public String getReason() {
        return reason.getValue();
    }

}