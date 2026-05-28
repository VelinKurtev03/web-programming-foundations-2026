package pu.fmi.webprogramming.service;

import org.springframework.stereotype.Component;
import pu.fmi.webprogramming.model.Delivery;

import java.time.LocalDateTime;

@Component
public class DeliveryEstimator {

  public LocalDateTime estimateArrivalTime(Delivery delivery) {

    LocalDateTime estimatedArrivalAt = delivery.getCreatedAt();

    if (delivery.getWarehouse().getCity().equals(delivery.getCustomer().getCity())) {
      estimatedArrivalAt = estimatedArrivalAt.plusDays(1);
    } else {
      estimatedArrivalAt = estimatedArrivalAt.plusDays(3);
    }

    if (delivery.getCourier() == null) {
      estimatedArrivalAt = estimatedArrivalAt.plusDays(2);
    }

    return estimatedArrivalAt;
  }
}
