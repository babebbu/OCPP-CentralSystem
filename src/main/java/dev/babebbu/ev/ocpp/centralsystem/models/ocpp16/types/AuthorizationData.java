package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorizationData {
    /**
     * Required. The identifier to which this authorization applies.
     */
    private String idTag;

    /**
     * Optional. (Required when UpdateType is Full) This contains information about authorization status,
     * expiry and parent id. For a Differential update the following applies:
     * If this element is present, then this entry SHALL be added or updated in the Local Authorization List.
     * If this element is absent, than the entry for this idTag in the Local Authorization List SHALL be deleted.
     */
    private IdTagInfo idTagInfo;
}
