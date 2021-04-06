package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateFirmwareRequest {
    /**
     * Required. This contains a string containing a URI pointing to a location from which to retrieve the firmware.
     */
    private String location;

    /**
     * Optional. This specifies how many times Charge Point must try to download the firmware before giving up.
     * If this field is not present, it is left to Charge Point to decide how many times it wants to retry.
     */
    private int retries;

    /**
     * Required. This contains the date and time after which the Charge Point is allowed to retrieve the (new) firmware.
     */
    private String retrieveDate;

    /**
     * Optional. The interval in seconds after which a retry may be attempted.
     * If this field is not present, it is left to Charge Point to decide how long to wait between attempts.
     */
    private int retryInterval;
}
