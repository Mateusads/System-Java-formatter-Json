package br.com.json.formatter.controller;

import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.Product;
import br.com.json.formatter.model.User;
import br.com.json.formatter.service.*;
import com.google.gson.Gson;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResponseToJson {

    public String responseJson(List<String> linesFile){
        Gson userJson = new Gson();
        StringBuilder userResponse = new StringBuilder();
        var usersCreated = createDataForJson(linesFile);
        for(var user : usersCreated){
            userResponse.append(userJson.toJson(user, User.class));
        }
        return userResponse.toString();
    }
    private Set<User> createDataForJson(List<String> fileComplete){
        Set<User> users = new HashSet<>();
        Set<Order> orders = new HashSet<>();
        Set<Product> products = new HashSet<>();
        SeparatingTypeElementsService separating = new SeparatingTypeElementsService();
        for(var lineFile : fileComplete){
            var elementsFileSeparedForColum = separating.separatingElements(lineFile);
            ProcessElementsService elementProcessor = new ProcessElementsService();
            var processedElement = elementProcessor.processingElements(elementsFileSeparedForColum);
            //CreateEntity entityCreate = new CreateEntity();
            CreateUserService userCreate = new CreateUserService();
            CreateOrderService orderCreate = new CreateOrderService();
            CreateProductService productCreate = new CreateProductService();
            var createdUser = userCreate.createUser((int)processedElement.get("user_id"), (String)processedElement.get("user_name"), users);
            var createdOrder = orderCreate.createOrder((int)processedElement.get("order_id"), (LocalDate) processedElement.get("order_date"), orders);
            var createdProduct = productCreate.createProduct((int)processedElement.get("product_id"), (Double) processedElement.get("product_value"), products);
            users.add(createdUser);
            orders.add(createdOrder);
            products.add(createdProduct);
            createdUser.addingOrdersInlist(createdOrder);
            createdOrder.addingProductsInlist(createdProduct);
        }
        return users;
    }

}
