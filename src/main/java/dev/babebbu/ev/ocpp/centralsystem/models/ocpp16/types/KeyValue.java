package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class KeyValue {

    /**
     * Required.
     */
    @NonNull
    private String key;

    /**
     * Required. False if the value can be set with the ChangeConfiguration message.
     */
    private boolean readonly;

    /**
     * Optional. If key is known but not set, this field may be absent.
     */
    private String value;
}
