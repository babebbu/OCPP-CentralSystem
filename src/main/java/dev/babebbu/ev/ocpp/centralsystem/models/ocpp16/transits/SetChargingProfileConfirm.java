package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.ChargingProfileStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SetChargingProfileConfirm {
    private ChargingProfileStatus status;
}
