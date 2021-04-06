package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnumOperator {

    public static <T> T from(EnumValue[] values, String s) {
        for(EnumValue value : values) {
            if (value.getValue().equals(s)) {
                return (T) value;
            }
        }
        return null;
    }

}
