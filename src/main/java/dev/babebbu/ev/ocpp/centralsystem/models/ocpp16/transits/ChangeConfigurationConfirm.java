package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ConfigurationStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ChangeConfigurationConfirm {
    /**
     * Required. Returns whether configuration change has been accepted.
     */
    @NonNull
    private ConfigurationStatus status;
}
