package dev.babebbu.ev.ocpp.centralsystem.repositories;

import dev.babebbu.ev.ocpp.centralsystem.models.entities.ChargePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargePointRepository extends JpaRepository<ChargePoint, Integer> {

    ChargePoint findByChargePointVendorAndChargePointModelAndChargePointSerialNumber(String chargePointVendor, String chargePointModel, String chargePointSerialNumber);

    ChargePoint findByChargePointSerialNumber(String chargePointSerialNumber);

}
