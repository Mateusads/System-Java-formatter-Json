package br.com.json.formatter.service;

import br.com.json.formatter.model.Order;

import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class CreateOrderService {

    public Order createOrder(int id, LocalDate date, Set<Order> orders) {
        var newOrder = createNewOrder(id, date);
        if(orders.contains(newOrder)) return existingOrder(id, orders);
        return newOrder;
    }

    private Order existingOrder(int id, Set<Order> orders) {
        AtomicReference<Order> existOrder = new AtomicReference<>();
        orders.iterator().forEachRemaining(order ->{
            if(order.getId() == id) existOrder.set(order);
        });
        return existOrder.get();
    }

    private Order createNewOrder(int id, LocalDate date) {
        return Order.builder()
                .id(id)
                .date(date)
                .build();
    }
}