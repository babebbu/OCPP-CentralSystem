package dev.babebbu.ev.ocpp.centralsystem.models.entities;

import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits.BootNotificationRequest;
import dev.babebbu.ev.ocpp.centralsystem.utils.ObjectMapperFactory;
import lombok.Data;
import lombok.SneakyThrows;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "charge_points")
@Data
public class ChargePoint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String chargePointVendor;

    private String chargePointModel;

    private String chargePointSerialNumber;

    public ChargePoint() {}

    @SneakyThrows
    public String toString() {
        return ObjectMapperFactory.getObjectMapper().writeValueAsString(this);
    }

    public static ChargePoint parseChargePoint(BootNotificationRequest request) {
        return new ChargePoint() {{
            setChargePointVendor(request.getChargePointVendor());
            setChargePointModel(request.getChargePointModel());
            setChargePointSerialNumber(request.getChargePointSerialNumber());
        }};
    }

}
