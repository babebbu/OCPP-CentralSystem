package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataTransferRequest {
    /**
     * Required. This identifies the Vendor specific implementation
     */
    @NonNull
    private String vendorId;

    /**
     * Optional. Additional identification field
     */
    private String messageId;

    /**
     * Optional. Data without specified length or format.
     */
    private String data;
}
