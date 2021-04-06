package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.AuthorizationData;
import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.UpdateType;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class SendLocalListRequest {
    /**
     * Required. In case of a full update this is the version number of the full list.
     * In case of a differential update it is the version number of the list after the update has been applied.
     */
    @NonNull
    private int listVersion;

    /**
     * Optional. In case of a full update this contains the list of values that form the new local authorization list.
     * In case of a differential update it contains the changes to be applied to the local authorization list in the Charge Point.
     * Maximum number of AuthorizationData elements is available in the configuration key: SendLocalListMaxLength
     */
    private List<AuthorizationData> localAuthorizationList;

    /**
     * Required. This contains the type of update (full or differential) of this request.
     */
    @NonNull
    private UpdateType updateType;
}
