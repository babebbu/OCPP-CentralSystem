package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.FirmwareStatus;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FirmwareStatusNotificationRequest {
    /**
     * Required. This contains the progress status of the firmware installation.
     */
    @NonNull
    private FirmwareStatus status;

    public String getStatus() {
        return status.getValue();
    }
}
