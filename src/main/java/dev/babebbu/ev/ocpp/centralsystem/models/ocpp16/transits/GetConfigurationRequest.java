package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetConfigurationRequest {
    /**
     * Optional. List of keys for which the configuration value is requested.
     */
    private String key;
}
