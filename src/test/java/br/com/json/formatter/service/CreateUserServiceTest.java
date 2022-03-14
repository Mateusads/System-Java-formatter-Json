package br.com.json.formatter.service;

import br.com.json.formatter.model.User;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class CreateUserServiceTest extends TestCase {

//    @Test
//    public void testCreatingEntityUser(){
//        String line = "0000000071                               Everett Beahan00000007610000000004     1881.5420210702";
//        SeparatingTypeElementsService elementsService = new SeparatingTypeElementsService();
//        var elementsByType= elementsService.separatingElements(line);
//        ProcessElementsService processElementsService = new ProcessElementsService();
//        CreateUserService createUserService = new CreateUserService();
//        Set<User> users = new HashSet<>();
//        var createdUser = createUserService.createUser(processElementsService.transformeStringToInt(elementsByType.get(0)), elementsByType.get(1), users);
//
//        Assert.assertEquals(71, createdUser.getId());
//        Assert.assertEquals("Everett Beahan", createdUser.getName());
//    }
//
//    @Test
//    public void testCreatingEntityUserMultipleLines(){
//        List<String> lines = new ArrayList<>();
//        Set<User> users = new LinkedHashSet<>();
//        List<User> userList = new ArrayList<>();
//        lines.add("0000000071                               Everett Beahan00000007610000000004     1881.5420210702");
//        lines.add("0000000071                               Everett Beahan00000007610000000004     1881.5420210702");
//        lines.add("0000000057                          Elidia Gulgowski IV00000006200000000000     1417.2520210919");
//        lines.add("0000000057                          Elidia Gulgowski IV00000006200000000004     100.02520210919");
//        SeparatingTypeElementsService elementsService = new SeparatingTypeElementsService();
//        for(var line : lines){
//            var elementsByType= elementsService.separatingElements(line);
//            ProcessElementsService processElementsService = new ProcessElementsService();
//            CreateUserService createUserService = new CreateUserService();
//            var createdUser = createUserService.createUser(processElementsService.transformeStringToInt(elementsByType.get(0)), elementsByType.get(1), users);
//            users.add(createdUser);
//            userList.add(createdUser);
//        }
//
//        Assert.assertEquals(71, userList.get(0).getId());
//        Assert.assertEquals("Everett Beahan", userList.get(1).getName());
//        Assert.assertEquals(57, userList.get(2).getId());
//        Assert.assertEquals("Elidia Gulgowski IV", userList.get(3).getName());
//    }
}