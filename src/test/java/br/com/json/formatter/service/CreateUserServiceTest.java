package br.com.json.formatter.service;

import br.com.json.formatter.model.User;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class CreateUserServiceTest extends TestCase {
    private static String LINE = "0000000071                               Everett Beahan00000007610000000004     1881.5420210702";

    @Test
    public void testCreatingEntityUser(){
        ExtractDataService extractDataService = new ExtractDataService();
        CreateUserService createUserService = new CreateUserService();
        var userName = extractDataService.extractName(LINE);
        var userId = extractDataService.extractUserId(LINE);
        Set<User> users = new HashSet<>();
        var createdUser = createUserService.createUser(userId, userName, users);

        assertThat("Everett Beahan").isEqualTo(createdUser.getName());
        assertThat(71).isEqualTo(createdUser.getId());
    }

    @Test
    public void testCreatingEntityUserMultipleLines(){
        CreateUserService createUserService = new CreateUserService();
        ExtractDataService extractDataService = new ExtractDataService();

        List<String> lines = new ArrayList<>();
        Set<User> users = new LinkedHashSet<>();
        List<User> userList = new ArrayList<>();
        lines.add("0000000071                               Everett Beahan00000007610000000004     1881.5420210702");
        lines.add("0000000071                               Everett Beahan00000007610000000004     1881.5420210702");
        lines.add("0000000057                          Elidia Gulgowski IV00000006200000000000     1417.2520210919");
        lines.add("0000000057                          Elidia Gulgowski IV00000006200000000004     100.02520210919");
        for(var line : lines){
            var createdUser = createUserService.createUser(extractDataService.extractUserId(line), extractDataService.extractName(line), users);
            users.add(createdUser);
            userList.add(createdUser);
        }

        assertThat("Everett Beahan").isEqualTo(userList.get(1).getName());
        assertThat(71).isEqualTo(userList.get(0).getId());
        assertThat("Elidia Gulgowski IV").isEqualTo(userList.get(3).getName());
        assertThat(57).isEqualTo(userList.get(2).getId());
    }
}