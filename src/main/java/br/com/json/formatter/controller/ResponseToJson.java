package br.com.json.formatter.controller;

import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.Product;
import br.com.json.formatter.model.User;
import br.com.json.formatter.service.CreateEntity;
import br.com.json.formatter.service.ProcessElementsFile;
import br.com.json.formatter.service.ReadingFile;
import br.com.json.formatter.service.SeparatingElementsFile;
import com.google.gson.Gson;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResponseToJson {

    public Set<User> createDataForJson(List<String> fileComplete){
        Set<User> users = new HashSet<>();
        Set<Order> orders = new HashSet<>();
        Set<Product> products = new HashSet<>();
        SeparatingElementsFile separating = new SeparatingElementsFile();
        for(var lineFile : fileComplete){
            var elementsFileSeparedForColum = separating.separatingElements(lineFile);
            ProcessElementsFile elementProcessor = new ProcessElementsFile();
            var processedElement = elementProcessor.processingElements(elementsFileSeparedForColum);
            CreateEntity entityCreate = new CreateEntity();
            var createdEntity = entityCreate.createEntity(processedElement, users, orders, products);
            users.add((User) createdEntity.get("user"));
            orders.add((Order) createdEntity.get("order"));
            products.add((Product) createdEntity.get("product"));
        }
        return users;
    }
    public String responseJson(String path){
        ReadingFile readingFile = new ReadingFile();
        Gson userJson = new Gson();
        String userResponse = "";
        var linesFile= readingFile.readingFile(path);
        var usersCreated = createDataForJson(linesFile);

        for(var user : usersCreated){            
            userResponse = userJson.toJson(user);
        }
        return userResponse;
    }
}
