package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.IdTagInfo;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class AuthorizeConfirm {
    /**
     * Required. This contains information about authorization status, expiry and parent id.
     */
    @NonNull
    private IdTagInfo idTagInfo;
}
