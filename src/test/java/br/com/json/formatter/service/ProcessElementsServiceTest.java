package br.com.json.formatter.service;

import org.junit.Assert;
import org.junit.Test;

public class ProcessElementsServiceTest {
    private static final double DELTA = 1e-15;

    @Test
    public void testProcessingElements(){
        SeparatingTypeElementsService separating = new SeparatingTypeElementsService();
        ProcessElementsService process = new ProcessElementsService();
        var listElements = (separating.separatingElements("0000000071                               Everett Beahan00000007590000000002      337.2120210808"));
        var userId = process.transformeStringToInt(listElements.get(0));
        var userName = listElements.get(1);
        var orderId= process.transformeStringToInt(listElements.get(2));
        var orderDate= process.transformeStringToDate(listElements.get(5));
        var productId= process.transformeStringToInt(listElements.get(3));
        var productValue = process.transformeStringToDouble(listElements.get(4));

        Assert.assertEquals(71, userId);
        Assert.assertEquals("Everett Beahan", userName);
        Assert.assertEquals(759, orderId);
        Assert.assertEquals("2021-08-08", orderDate.toString());
        Assert.assertEquals(2, productId);
        Assert.assertEquals(337.21, productValue, DELTA);
    }

}