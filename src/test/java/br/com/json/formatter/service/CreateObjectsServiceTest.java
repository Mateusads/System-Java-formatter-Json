package br.com.json.formatter.service;


import br.com.json.formatter.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateObjectsServiceTest {
    private static String LINE1 = "0000000071                               Everett Beahan00000007610000000004     1881.5420210702";
    private static String LINE2 = "0000000071                               Everett Beahan00000007610000000004     1881.5420210702";
    private static String LINE3 = "0000000057                          Elidia Gulgowski IV00000006200000000000     1417.2520210919";
    private static String LINE4 = "0000000057                          Elidia Gulgowski IV00000006200000000000     100.02520210919";

    @Test
    public void usingCreateObjectsForUserOrderProducts(){
        List<String> lines = new ArrayList<>();
        lines.add(LINE1);
        lines.add(LINE3);
        CreateObjectsService createObjectsService = new CreateObjectsService();
        var objectsCreated = createObjectsService.createObjectFromLines(lines);
        List<User> obcjectList = new ArrayList<>();
        objectsCreated.forEach(user -> obcjectList.add((User) user));

        assertThat(71).isEqualTo(obcjectList.get(0).getId());
        assertThat("Everett Beahan").isEqualTo(obcjectList.get(0).getName());
        assertThat(761).isEqualTo(obcjectList.get(0).getOrders().get(0).getId());
        assertThat("2021-07-02").isEqualTo(obcjectList.get(0).getOrders().get(0).getDate().toString());
        assertThat(4).isEqualTo(obcjectList.get(0).getOrders().get(0).getProducts().get(0).getId());
        assertThat(1881.54).isEqualTo(obcjectList.get(0).getOrders().get(0).getProducts().get(0).getValue());

        assertThat(57).isEqualTo(obcjectList.get(1).getId());
        assertThat("Elidia Gulgowski IV").isEqualTo(obcjectList.get(1).getName());
        assertThat(620).isEqualTo(obcjectList.get(1).getOrders().get(0).getId());
        assertThat("2021-09-19").isEqualTo(obcjectList.get(1).getOrders().get(0).getDate().toString());
        assertThat(0).isEqualTo(obcjectList.get(1).getOrders().get(0).getProducts().get(0).getId());
        assertThat(1417.25).isEqualTo(obcjectList.get(1).getOrders().get(0).getProducts().get(0).getValue());
    }
}