package br.com.json.formatter.service;

import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.Product;
import br.com.json.formatter.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateObjectsService {

    public Set<User> createObjectFromLines(List<String> lines){
        return create(lines);
    }

    private Set<User> create(List<String> lines) {
        try{
            ExtractDataService extractService = new ExtractDataService();
            CreateUserService createUserService = new CreateUserService();
            CreateOrderService createOrderService = new CreateOrderService();
            CreateProductService createProductService = new CreateProductService();
            Set<User> users = new HashSet<>();
            Set<Order> orders = new HashSet<>();
            Set<Product> products = new HashSet<>();
            for (var line : lines){
                var createdUser = createUserService.createUser(extractService.extractUserId(line), extractService.extractName(line), users);
                users.add(createdUser);
                var createdOrder = createOrderService.createOrder(extractService.extractOrderId(line), extractService.extractOrderDate(line), orders);
                orders.add(createdOrder);
                var createdProduct = createProductService.createProduct(extractService.extractProductId(line), extractService.extractProductValue(line), products);
                products.add(createdProduct);
                createdUser.addingOrdersInlist(createdOrder);
                createdOrder.addingProductsInlist(createdProduct);
            }
            return users;
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
