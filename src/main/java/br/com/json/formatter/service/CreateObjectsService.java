package br.com.json.formatter.service;

import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.Product;
import br.com.json.formatter.model.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateObjectsService {

    public Set<User> createObjectFromLines(List<String> lines) {
        return create(lines);
    }

    private Set<User> create(List<String> lines) {
        ExtractDataService extractService = new ExtractDataService();
        Set<User> users = new HashSet<>();
        Set<Order> orders = new HashSet<>();
        Set<Product> products = new HashSet<>();
        for (var line : lines) {
            var createdUser = createUser(extractService.extractUserId(line), extractService.extractName(line), users);
            users.add(createdUser);
            var createdOrder = createOrder(extractService.extractOrderId(line), extractService.extractOrderDate(line), orders);
            orders.add(createdOrder);
            var createdProduct = createProduct(extractService.extractProductId(line), extractService.extractProductValue(line), products);
            products.add(createdProduct);
            createdUser.addingOrdersInlist(createdOrder);
            createdOrder.addingProductsInlist(createdProduct);
        }
        return users;
    }

    private User createUser(int id, String name, Set<User> users){
        CreateUserService createUserService = new CreateUserService();
        return createUserService.createUser(id, name, users);
    }

    private Order createOrder(int id, LocalDate date, Set<Order> orders){
        CreateOrderService createOrderService = new CreateOrderService();
        return createOrderService.createOrder(id, date, orders);
    }

    private Product createProduct(int id, double value, Set<Product> products){
        CreateProductService createProductService = new CreateProductService();
        return createProductService.createProduct(id, value, products);
    }


}
