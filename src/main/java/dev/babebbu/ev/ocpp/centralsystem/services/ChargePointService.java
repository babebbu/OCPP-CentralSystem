package dev.babebbu.ev.ocpp.centralsystem.services;

import dev.babebbu.ev.ocpp.centralsystem.models.entities.ChargePoint;
import dev.babebbu.ev.ocpp.centralsystem.models.ocpp16.transits.BootNotificationRequest;
import dev.babebbu.ev.ocpp.centralsystem.repositories.ChargePointRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Service
public class ChargePointService {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    private final ChargePointRepository chargePointRepository;

    public ChargePointService(EntityManager entityManager, ChargePointRepository chargePointRepository) {
        this.entityManager = entityManager;
        this.chargePointRepository = chargePointRepository;
        this.criteriaBuilder = this.entityManager.getCriteriaBuilder();
    }

    public ChargePoint findChargePoint(BootNotificationRequest request) throws
       NoResultException, NonUniqueResultException, QueryTimeoutException {
        CriteriaQuery<ChargePoint> criteriaQuery = criteriaBuilder.createQuery(ChargePoint.class);
        Root<ChargePoint> chargePointRoot = criteriaQuery.from(ChargePoint.class);

        criteriaQuery.where(
            criteriaBuilder.and(
                criteriaBuilder.equal(chargePointRoot.get("chargePointVendor"), request.getChargePointVendor()),
                criteriaBuilder.equal(chargePointRoot.get("chargePointModel"), request.getChargePointModel()),
                criteriaBuilder.equal(chargePointRoot.get("chargePointSerialNumber"), request.getChargePointSerialNumber())
            )
        );

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public ChargePoint findChargePointBySerialNumber(String serialNumber) {
        return chargePointRepository.findByChargePointSerialNumber(serialNumber);
    }

}
