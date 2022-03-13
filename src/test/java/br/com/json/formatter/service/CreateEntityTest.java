package br.com.json.formatter.service;


import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.Product;
import br.com.json.formatter.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CreateEntityTest{
    private static final double DELTA = 1e-15;

    @Test
    public void testCreatingEntity(){
        SeparatingElementsFile separating = new SeparatingElementsFile();
        ProcessElementsFile process = new ProcessElementsFile();
        Set<User> users = new HashSet<>();
        Set<Order> orders = new HashSet<>();
        Set<Product> products = new HashSet<>();
        var listElements = (separating.separatingElements("0000000071                               Everett Beahan00000007590000000002      337.2120210808"));
        var listObjectElements = process.processingElements(listElements);
        CreateEntity newEntity = new CreateEntity();
        var entitysReturn = newEntity.createEntity(listObjectElements, users, orders, products);
        var newUser = (User) entitysReturn.get("user");
        var newOrder = (Order) entitysReturn.get("order");
        var newProduct = (Product) entitysReturn.get("product");

        Assert.assertEquals(71, newUser.getId());
        Assert.assertEquals("Everett Beahan", newUser.getName());
        Assert.assertEquals(759, newOrder.getId());
        Assert.assertEquals("2021-08-08", newOrder.getDate().toString());
        Assert.assertEquals(2, newProduct.getId());
        Assert.assertEquals(337.21, newProduct.getValue(), DELTA);

    }

    @Test
    public void testUserData(){
        SeparatingElementsFile separating = new SeparatingElementsFile();
        ProcessElementsFile process = new ProcessElementsFile();
        Set<User> users = new HashSet<>();
        Set<Order> orders = new HashSet<>();
        Set<Product> products = new HashSet<>();
        var listElements = (separating.separatingElements("0000000071                               Everett Beahan00000007590000000002      337.2120210808"));
        var listObjectElements = process.processingElements(listElements);
        CreateEntity newEntity = new CreateEntity();
        var entitysReturn = newEntity.createEntity(listObjectElements, users, orders, products);
        var newUser = (User) entitysReturn.get("user");

        Assert.assertEquals(71, newUser.getId());
        Assert.assertEquals("Everett Beahan", newUser.getName());
        Assert.assertEquals(759, newUser.getOrders().get(0).getId());
        Assert.assertEquals(337.21, newUser.getOrders().get(0).getTotal(), DELTA);
        Assert.assertEquals("2021-08-08", newUser.getOrders().get(0).getDate().toString());
        Assert.assertEquals(2, newUser.getOrders().get(0).getProducts().get(0).getId());
        Assert.assertEquals(337.21, newUser.getOrders().get(0).getProducts().get(0).getValue(), DELTA);

    }

    @Test
    public void createMultipleOrdersForUser(){

        SeparatingElementsFile separating = new SeparatingElementsFile();
        ProcessElementsFile process = new ProcessElementsFile();
        Set<User> users = new HashSet<>();
        Set<Order> orders = new HashSet<>();
        Set<Product> products = new HashSet<>();
        Map<String, String> listElements = new HashMap<>();
        List<String> listDataFile = new ArrayList<>();
        User newUser = new User();
        listDataFile.add("0000000071                               Everett Beahan00000007610000000004     1881.5420210702");
        listDataFile.add("0000000071                               Everett Beahan00000007610000000005     1001.5020210702");
        for(var list : listDataFile){
           listElements = separating.separatingElements(list);
            var listObjectElements = process.processingElements(listElements);
            CreateEntity newEntity = new CreateEntity();
            var entitysReturn = newEntity.createEntity(listObjectElements, users, orders, products);
            users.add((User) entitysReturn.get("user"));
            orders.add((Order) entitysReturn.get("order"));
            products.add((Product) entitysReturn.get("product"));
            newUser = (User) entitysReturn.get("user");
        }
            Assert.assertEquals(71, newUser.getId());
            Assert.assertEquals("Everett Beahan", newUser.getName());
            Assert.assertEquals(761, newUser.getOrders().get(0).getId());
            Assert.assertEquals(2883.04, newUser.getOrders().get(0).getTotal(), DELTA);
            Assert.assertEquals("2021-07-02", newUser.getOrders().get(0).getDate().toString());
            Assert.assertEquals(4, newUser.getOrders().get(0).getProducts().get(0).getId());
            Assert.assertEquals(1881.54, newUser.getOrders().get(0).getProducts().get(0).getValue(), DELTA);

    }

}