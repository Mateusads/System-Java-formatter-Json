package br.com.json.formatter.controller;

import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.Product;
import br.com.json.formatter.model.User;
import br.com.json.formatter.service.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResponseToJson {

    public String responseJson(List<String> linesFile){
        Gson userJson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        StringBuilder userResponse = new StringBuilder();
        var usersCreated = createDataForJson(linesFile);
        for(var user : usersCreated){
            userResponse.append(userJson.toJson(user));
        }
        return userResponse.toString();
    }
    private Set<User> createDataForJson(List<String> fileComplete){
        Set<User> users = new HashSet<>();
        Set<Order> orders = new HashSet<>();
        Set<Product> products = new HashSet<>();
        CreateUserService userCreate = new CreateUserService();
        CreateOrderService orderCreate = new CreateOrderService();
        CreateProductService productCreate = new CreateProductService();
        ProcessElementsService elementProcessor = new ProcessElementsService();
        SeparatingTypeElementsService separating = new SeparatingTypeElementsService();
        for(var lineFile : fileComplete){
            var elements = separating.separatingElements(lineFile);
            var createdUser = userCreate.createUser(elementProcessor.transformeStringToInt(elements.get(0)), elements.get(1), users);
            var createdOrder = orderCreate.createOrder(elementProcessor.transformeStringToInt(elements.get(2)), elementProcessor.transformeStringToDate(elements.get(5)), orders);
            var createdProduct = productCreate.createProduct(elementProcessor.transformeStringToInt(elements.get(3)), elementProcessor.transformeStringToDouble(elements.get(4)), products);
            users.add(createdUser);
            orders.add(createdOrder);
            products.add(createdProduct);
            createdUser.addingOrdersInlist(createdOrder);
            createdOrder.addingProductsInlist(createdProduct);
        }
        return users;
    }

}
