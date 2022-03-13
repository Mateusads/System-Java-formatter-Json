package br.com.json.formatter.service;

import br.com.json.formatter.model.User;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CreateUserServiceTest extends TestCase {

    @Test
    public void testCreatingEntity(){
        String line = "0000000071                               Everett Beahan00000007610000000004     1881.5420210702";
        SeparatingTypeElementsService elementsService = new SeparatingTypeElementsService();
        var elementsByType= elementsService.separatingElements(line);
        ProcessElementsService processElementsService = new ProcessElementsService();
        CreateUserService createUserService = new CreateUserService();
        Set<User> users = new HashSet<>();
        var createdUser = createUserService.createUser(processElementsService.transformeStringToInt(elementsByType.get(0)), elementsByType.get(1), users);

        Assert.assertEquals(71, createdUser.getId());
        Assert.assertEquals("Everett Beahan", createdUser.getName());
    }

}