package br.com.json.formatter.service;

import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.Product;
import br.com.json.formatter.model.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CreateEntity {

    public Map<String, Object> createEntity(Map<String, Object> elementsMap, Set<User> users, Set<Order> orders, Set<Product> products){
        var newUser = createUser((int) elementsMap.get("user_id"), (String) elementsMap.get("user_name"), users);
        var newOrder = createOrder((int) elementsMap.get("order_id"), (LocalDate) elementsMap.get("order_date"), orders);
        var newProduct = createProduct((int) elementsMap.get("product_id"), (double) elementsMap.get("product_value"), products);
        newUser.addingOrdersInlist(newOrder);
        newOrder.addingProductsInlist(newProduct);

        Map<String, Object> entitysMap = new HashMap<>();
        entitysMap.put("user", newUser);
        entitysMap.put("order", newOrder);
        entitysMap.put("product", newProduct);
        return entitysMap;
    }

    private User createUser(int id, String name, Set<User> users){
        for(var user : users){
            if(user.getId() == id){
                return user;
            }
        }
        var createdUser = User.builder()
                    .id(id)
                    .name(name)
                    .build();
        return createdUser;
    }

    private Order createOrder(int id, LocalDate date, Set<Order> orders){
        for(var order : orders){
            if(order.getId() == id){
                return order;
            }
        }
        Order createdOrder = Order.builder()
                .id(id)
                .date(date)
                .build();
        return createdOrder;
    }

    private Product createProduct(int id, double value, Set<Product> products){

        Product createdProduct = Product.builder()
                .id(id)
                .value(value)
                .build();
        return createdProduct;
    }




}
