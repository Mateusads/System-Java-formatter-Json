package br.com.json.formatter.service;

import br.com.json.formatter.model.Order;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

public class CreateOrderService {

    public Order createOrder(int id, LocalDate date, Set<Order> orders) {
        var newOrder = createNewOrder(id, date);
        if(orders.contains(newOrder)) return existingOrder(id, orders);
        return newOrder;
    }

    private Order existingOrder(int id, Set<Order> orders) {
        Iterator<Order> ordersAsIterator = orders.iterator();
        while (ordersAsIterator.hasNext()){
            Order orderNext = ordersAsIterator.next();
            if(orderNext.getId() == id) return orderNext;
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