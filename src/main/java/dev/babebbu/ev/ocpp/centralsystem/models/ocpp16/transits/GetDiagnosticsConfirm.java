package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetDiagnosticsConfirm {
    /**
     * Optional. This contains the name of the file with diagnostic information that will be uploaded. This field is not present when no diagnostic information is
     * available.
     */
    private String fileName;
}
