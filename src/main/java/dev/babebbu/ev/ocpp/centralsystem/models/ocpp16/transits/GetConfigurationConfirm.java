package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.KeyValue;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetConfigurationConfirm {
    /**
     * Optional. List of requested or known keys
     */
    private KeyValue configurationKey;

    /**
     * Optional. Requested keys that are unknown
     */
    private String unknownKey;
}
