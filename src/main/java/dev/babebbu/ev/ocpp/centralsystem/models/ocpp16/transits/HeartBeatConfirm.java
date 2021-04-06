package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class HeartBeatConfirm {
    /**
     * Required. This contains the current time of the Central System.
     */
    @NonNull
    private String currentTime;
}
