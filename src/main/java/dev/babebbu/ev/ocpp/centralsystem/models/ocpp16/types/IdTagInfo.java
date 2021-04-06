package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.AuthorizationStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class IdTagInfo {

    /**
     * Optional. This contains the date at which idTag should be removed from the Authorization Cache.
     */
    private String expiryDate;

    /**
     * Optional. This contains the parent-identifier.
     */
    private String parentIdTag;

    /**
     * Required. This contains whether the idTag has been accepted or not by the Central System.
     */
    @NonNull
    private AuthorizationStatus status;

}
