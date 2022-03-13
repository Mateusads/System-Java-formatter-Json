package br.com.json.formatter.controller;

import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.Product;
import br.com.json.formatter.model.User;
import br.com.json.formatter.service.*;
import com.google.gson.Gson;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResponseToJson {

    public String responseJson(List<String> linesFile){
        Gson userJson = new Gson();
        String userResponse = "";
        var usersCreated = createDataForJson(linesFile);
        for(var user : usersCreated){
            userResponse = userJson.toJson(user, User.class);
        }
        return userResponse;
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
            CreateOrderService userOrder = new CreateOrderService();
            CreateProductService userProduct = new CreateProductService();
            var createdUser = userCreate.createUser((int)processedElement.get("user_id"), (String)processedElement.get("user_name"), users);
            users.add(createdUser);
            //orders.add((Order) createdEntity.get("order"));
            //products.add((Product) createdEntity.get("product"));
            //newUser.addingOrdersInlist(newOrder);
            //newOrder.addingProductsInlist(newProduct);
        }
        return users;
    }

}
