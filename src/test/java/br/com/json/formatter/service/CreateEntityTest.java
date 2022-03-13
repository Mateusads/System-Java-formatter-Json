package br.com.json.formatter.service;


import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.Product;
import br.com.json.formatter.model.User;
import org.junit.Assert;
import org.junit.Test;

public class CreateEntityTest{
    private static final double DELTA = 1e-15;

    @Test
    public void testCreatingEntity(){
        SeparatingElementsFile separating = new SeparatingElementsFile();
        ProcessElementsFile process = new ProcessElementsFile();
        var listElements = (separating.separatingElements("0000000071                               Everett Beahan00000007590000000002      337.2120210808"));
        var listObjectElements = process.processingElements(listElements);
        CreateEntity newEntity = new CreateEntity();
        var entitysReturn = newEntity.createEntity(listObjectElements);
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
        var listElements = (separating.separatingElements("0000000071                               Everett Beahan00000007590000000002      337.2120210808"));
        var listObjectElements = process.processingElements(listElements);
        CreateEntity newEntity = new CreateEntity();
        var entitysReturn = newEntity.createEntity(listObjectElements);
        var newUser = (User) entitysReturn.get("user");

        Assert.assertEquals(71, newUser.getId());
        Assert.assertEquals("Everett Beahan", newUser.getName());
        Assert.assertEquals(759, newUser.getOrders().get(0).getId());
        Assert.assertEquals(337.21, newUser.getOrders().get(0).getTotal(), DELTA);
        Assert.assertEquals("2021-08-08", newUser.getOrders().get(0).getDate().toString());
        Assert.assertEquals(2, newUser.getOrders().get(0).getProducts().get(0).getId());
        Assert.assertEquals(337.21, newUser.getOrders().get(0).getProducts().get(0).getValue(), DELTA);

    }

}