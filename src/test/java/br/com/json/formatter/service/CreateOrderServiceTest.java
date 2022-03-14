package br.com.json.formatter.service;

import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.User;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

public class CreateOrderServiceTest extends TestCase {

//    @Test
//    public void testCreatingEntityOrder(){
//        String line = "0000000071                               Everett Beahan00000007610000000004     1881.5420210702";
//        SeparatingTypeElementsService elementsService = new SeparatingTypeElementsService();
//        var elementsByType= elementsService.separatingElements(line);
//        ProcessElementsService processElementsService = new ProcessElementsService();
//        CreateOrderService createOrderService = new CreateOrderService();
//        Set<Order> orders = new HashSet<>();
//        var createdOrder = createOrderService.createOrder(processElementsService.transformeStringToInt(elementsByType.get(3)),
//                processElementsService.transformeStringToDate(elementsByType.get(5)), orders);
//
//        Assert.assertEquals(71, createdOrder.getId());
//        Assert.assertEquals("2021-07-02", createdOrder.getDate());
//    }
//
//    @Test
//    public void testCreatingEntityUserMultipleLines(){
//        List<String> lines = new ArrayList<>();
//        Set<Order> orders = new LinkedHashSet<>();
//        List<Order> ordersList = new ArrayList<>();
//        lines.add("0000000071                               Everett Beahan00000007610000000004     1881.5420210702");
//        lines.add("0000000071                               Everett Beahan00000007610000000004     1881.5420210702");
//        lines.add("0000000057                          Elidia Gulgowski IV00000006200000000000     1417.2520210919");
//        lines.add("0000000057                          Elidia Gulgowski IV00000006200000000000     100.02520210919");
//        SeparatingTypeElementsService elementsService = new SeparatingTypeElementsService();
//        for(var line : lines){
//            var elementsByType= elementsService.separatingElements(line);
//            ProcessElementsService processElementsService = new ProcessElementsService();
//            CreateOrderService createOrderService = new CreateOrderService();
//            var createdOrder = createOrderService.createOrder(processElementsService.transformeStringToInt(elementsByType.get(3)),
//                    processElementsService.transformeStringToDate(elementsByType.get(5)), orders);
//            orders.add(createdOrder);
//        }
//        orders.forEach(order -> ordersList.add(order));
//
//        Assert.assertEquals(4, ordersList.get(0).getId());
//        Assert.assertEquals("2021-07-02", ordersList.get(0).getDate().toString());
//        Assert.assertEquals(0, ordersList.get(1).getId());
//        Assert.assertEquals("2021-09-19", ordersList.get(1).getDate().toString());
//
//    }

}