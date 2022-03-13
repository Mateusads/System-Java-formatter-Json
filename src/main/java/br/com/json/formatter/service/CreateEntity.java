package br.com.json.formatter.service;

import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.Product;
import br.com.json.formatter.model.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CreateEntity {

    public Map<String, Object> createEntity(Map<String, Object> elementsMap){
        var newUser = createUser((int) elementsMap.get("user_id"), (String) elementsMap.get("user_name"));
        var newOrder = createOrder((int) elementsMap.get("order_id"), (LocalDate) elementsMap.get("order_date"), newUser);
        var newProduct = createProduct((int) elementsMap.get("product_id"), (double) elementsMap.get("product_value"), newOrder);

        Map<String, Object> entitysMap = new HashMap<>();
        entitysMap.put("user", newUser);
        entitysMap.put("order", newOrder);
        entitysMap.put("product", newProduct);
        return entitysMap;
    }

    private User createUser(int id, String name){
        User createdUser = User.builder()
                .id(id)
                .name(name)
                .build();
        return createdUser;
    }

    private Order createOrder(int id, LocalDate date, User user){
        Order createdOrder = Order.builder()
                .id(id)
                .date(date)
                .user(user)
                .build();
        return createdOrder;
    }

    private Product createProduct(int id, double value, Order order){
        Product createdProduct = Product.builder()
                .id(id)
                .value(value)
                .order(order)
                .build();
        return createdProduct;
    }




}
