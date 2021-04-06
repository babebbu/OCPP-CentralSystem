package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class GetDiagnosticsRequest {
    /**
     * Required. This contains the location (directory) where the diagnostics file shall be uploaded to.
     */
    @NonNull
    private String location;

    /**
     * Optional. This specifies how many times Charge Point must try to upload the diagnostics before giving up.
     * If this field is not present, it is left to Charge Point to decide how many times it wants to retry.
     */
    private int retries;

    /**
     * Optional. The interval in seconds after which a retry may be attempted.
     * If this field is not present, it is left to Charge Point to decide how long to wait between attempts.
     */
    private int retryInterval;

    /**
     * Optional. This contains the date and time of the oldest logging information to include in the diagnostics.
     */
    private String startTime;

    /**
     * Optional. This contains the date and time of the latest logging information to include in the diagnostics.
     */
    private String stopTime;
}
