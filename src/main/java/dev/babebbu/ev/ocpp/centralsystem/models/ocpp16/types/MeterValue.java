package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MeterValue {

    /**
     * Required. Timestamp for measured value(s).
     */
    private String timestamp;

    /**
     * Required. One or more measured values
     */
    private SampledValue sampledValue;

}
