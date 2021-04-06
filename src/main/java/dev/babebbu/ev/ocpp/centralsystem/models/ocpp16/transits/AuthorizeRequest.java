package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizeRequest {
    /**
     * Required. This contains the identifier that needs to be authorized.
     */
    @NonNull
    private String idTag;
}
