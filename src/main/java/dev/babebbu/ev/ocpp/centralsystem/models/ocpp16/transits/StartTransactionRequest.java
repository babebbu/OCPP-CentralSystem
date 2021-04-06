package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StartTransactionRequest {

    /**
     * Required. This identifies which connector of the Charge Point is used.
     */
    @NonNull
    private int connectorId;

    /**
     * Required. This contains the identifier for which a transaction has to be started.
     */
    @NonNull
    private String idTag;

    /**
     * Required. This contains the meter value in Wh for the connector at start of the transaction.
     */
    @NonNull
    private int meterStart;

    /**
     * Optional. This contains the id of the reservation that terminates as a result of this transaction.
     */
    private int reservationId;

    /**
     * Required. This contains the date and time on which the transaction is started.
     */
    @NonNull
    private String timestamp;

}
