package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.DiagnosticsStatus;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticsStatusNotificationRequest {
    /**
     * Required. This contains the status of the diagnostics upload.
     */
    @NonNull
    private DiagnosticsStatus status;

    public String getStatus() {
        return status.getValue();
    }
}
