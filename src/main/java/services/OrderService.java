package services;

import entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shipment;

    public OrderService(ShippingService shipment) {
        this.shipment = shipment;
    }

    public Double total(Order order) {
        return order.getBasic() - (order.getBasic() * order.getDiscount()/100) + shipment.Shipment(order.getBasic());
    }
}
