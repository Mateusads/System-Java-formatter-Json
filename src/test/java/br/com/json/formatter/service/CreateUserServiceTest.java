package br.com.json.formatter.service;

import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.Product;
import br.com.json.formatter.model.User;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateUserServiceTest extends TestCase {
    private static final double DELTA = 1e-15;

    @Test
    public void testCreatingEntity(){
        String line = "0000000071                               Everett Beahan00000007610000000004     1881.5420210702";
        SeparatingTypeElementsService elementsService = new SeparatingTypeElementsService();
        var elementsByType= elementsService.separatingElements(line);
        ProcessElementsService processElementsService = new ProcessElementsService();
        var elementsProcess = processElementsService.processingElements(elementsByType);
        CreateUserService createUserService = new CreateUserService();
        Set<User> users = new HashSet<>();
        var createdUser = createUserService.createUser((int)elementsProcess.get("user_id"), (String)elementsProcess.get("user_name"), users);

        Assert.assertEquals(71, createdUser.getId());
        Assert.assertEquals("Everett Beahan", createdUser.getName());
    }

}