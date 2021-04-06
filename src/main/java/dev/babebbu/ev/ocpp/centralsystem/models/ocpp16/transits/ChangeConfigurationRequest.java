package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ChangeConfigurationRequest {
    /**
     * Required. The name of the configuration setting to change.
     * See for standard configuration key names and associated values
     */
    @NonNull
    private String key;

    /**
     *
     Required. The new value as string for the setting.
     See for standard configuration key names and associated values
     */
    @NonNull
    private String value;
}
