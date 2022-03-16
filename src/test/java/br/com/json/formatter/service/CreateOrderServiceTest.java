package br.com.json.formatter.service;

import br.com.json.formatter.model.Order;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateOrderServiceTest extends TestCase {
    private static String LINE1 = "0000000071                               Everett Beahan00000007610000000004     1881.5420210702";
    private static String LINE2 = "0000000071                               Everett Beahan00000007610000000004     1881.5420210702";
    private static String LINE3 = "0000000057                          Elidia Gulgowski IV00000006200000000000     1417.2520210919";
    private static String LINE4 = "0000000057                          Elidia Gulgowski IV00000006200000000000     100.02520210919";

    @Test
    public void testCreatingEntityOrder(){
        ExtractDataService extractDataService = new ExtractDataService();
        CreateOrderService createOrderService = new CreateOrderService();
        Set<Order> orders = new HashSet<>();
        var createdOrder = createOrderService.createOrder(extractDataService.extractOrderId(LINE1), extractDataService.extractOrderDate(LINE1), orders);

        assertThat(761).isEqualTo(createdOrder.getId());
        assertThat("2021-07-02").isEqualTo(createdOrder.getDate().toString());
    }

    @Test
    public void testCreatingEntityUserMultipleLines(){
        CreateOrderService createOrderService = new CreateOrderService();
        ExtractDataService extractDataService = new ExtractDataService();
        List<String> lines = new ArrayList<>();
        Set<Order> orders = new LinkedHashSet<>();
        List<Order> orderList = new ArrayList<>();
        lines.add(LINE1);
        lines.add(LINE2);
        lines.add(LINE3);
        lines.add(LINE4);
        for(var line : lines){
            var createdOrder = createOrderService.createOrder(extractDataService.extractOrderId(line), extractDataService.extractOrderDate(line), orders);
            orders.add(createdOrder);
            orderList.add(createdOrder);
        }

        assertThat("2021-07-02").isEqualTo(orderList.get(0).getDate().toString());
        assertThat(761).isEqualTo(orderList.get(1).getId());
        assertThat("2021-09-19").isEqualTo(orderList.get(2).getDate().toString());
        assertThat(620).isEqualTo(orderList.get(3).getId());
    }
}