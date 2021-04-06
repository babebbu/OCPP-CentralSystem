package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types.RegistrationStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BootNotificationConfirm {

    /**
     * Required. This contains the Central System’s current time.
     */
    @NonNull
    private String currentTime;

    /**
     * Required. When RegistrationStatus is Accepted, this contains the heartbeat interval in seconds.
     * If the Central System returns something other than Accepted, the value of the interval field indicates
     * the minimum wait time before sending a next BootNotification request.
     */
    @NonNull
    private int interval;

    /**
     * Required. This contains whether the Charge Point has been registered within the System Central.
     */
    @NonNull
    private RegistrationStatus status;


    public String getStatus() {
        return status.getValue();
    }

}
