package br.com.json.formatter.service;

import br.com.json.formatter.model.Order;

import java.time.LocalDate;
import java.util.Set;

public class CreateOrderService {

    public Order createOrder(int id, LocalDate date, Set<Order> orders) {
        var newOrder = existingOrder(id, orders);
        if (newOrder == null) newOrder = createNewOrder(id, date);
        return newOrder;
    }

    private Order existingOrder(int id, Set<Order> orders) {
        for (var order : orders) {
            if (order.getId() == id) return order;
        }
        return null;
    }

    private Order createNewOrder(int id, LocalDate date) {
        return Order.builder()
                .id(id)
                .date(date)
                .build();
    }

}