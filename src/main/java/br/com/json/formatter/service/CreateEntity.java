package br.com.json.formatter.service;

import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.Product;
import br.com.json.formatter.model.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CreateEntity {

    public Map<String, Object> createEntity(Map<String, String> listElements){
        String dateOrder = listElements.get("order_date");
        LocalDate orderDate = LocalDate.of(Integer.parseInt(dateOrder.substring(0,4)), Integer.parseInt(dateOrder.substring(4,6)), Integer.parseInt(dateOrder.substring(6,8)));
        User newUser = createUser(Integer.parseInt(listElements.get("user_id")), listElements.get("user_name"));
        Order newOrder = createOrder(Integer.parseInt(listElements.get("order_id")), orderDate, newUser);
        Product newProduct = createProduct(Integer.parseInt(listElements.get("product_id")), Double.parseDouble(listElements.get("product_value")), newOrder);
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
