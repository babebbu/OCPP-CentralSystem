package dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.types;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChargingProfile {
    /**
     * Required. Unique identifier for this profile.
     */
    @NonNull
    private int chargingProfileId;

    /**
     * Optional. Only valid if ChargingProfilePurpose is set to TxProfile, the transactionId MAY be used to match the profile to a specific transaction.
     */
    private int transactionId;

    /**
     * Required. Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.
     */
    @NonNull
    private int stackLevel;

    /**
     * Required. Defines the purpose of the schedule transferred by this message.
     */
    @NonNull
    private ChargingProfilePurposeType chargingProfilePurpose;

    /**
     * Required. Indicates the kind of schedule.
     */
    @NonNull
    private ChargingProfileKindType chargingProfileKind;

    /**
     * Optional. Indicates the start point of a recurrence.
     */
    private RecurrencyKindType recurrencyKind;

    /**
     * Optional. Point in time at which the profile starts to be valid. If absent, the profile is valid as soon as it is received by the Charge Point.
     */
    private String validFrom;

    /**
     *
     * Optional. Point in time at which the profile stops to be valid. If absent, the profile is valid until it is replaced by another profile.
     */
    private String validTo;

    /**
     * Required. Contains limits for the available power or current over time.
     */
    @NonNull
    private ChargingSchedule chargingSchedule;

    public ChargingProfile(int chargingProfileId,
                           int transactionId,
                           int stackLevel,
                           ChargingProfilePurposeType chargingProfilePurpose,
                           ChargingProfileKindType chargingProfileKind,
                           ChargingSchedule chargingSchedule) {
        setChargingProfileId(chargingProfileId);
        setTransactionId(transactionId);
        setStackLevel(stackLevel);
        setChargingProfilePurpose(chargingProfilePurpose);
        setChargingProfileKind(chargingProfileKind);
        setChargingSchedule(chargingSchedule);
    }
}
