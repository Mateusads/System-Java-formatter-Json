package br.com.json.formatter.service;

import org.junit.Assert;
import org.junit.Test;

public class ProcessElementsServiceTest {

    @Test
    public void testProcessingElements(){
        SeparatingTypeElementsService separating = new SeparatingTypeElementsService();
        ProcessElementsService process = new ProcessElementsService();
        var listElements = (separating.separatingElements("0000000071                               Everett Beahan00000007590000000002      337.2120210808"));
        var listElementsProcessed = process.processingElements(listElements);
        Assert.assertEquals(71, listElementsProcessed.get("user_id"));
        Assert.assertEquals("Everett Beahan", listElementsProcessed.get("user_name"));
        Assert.assertEquals(759, listElementsProcessed.get("order_id"));
        Assert.assertEquals("2021-08-08", listElementsProcessed.get("order_date").toString());
        Assert.assertEquals(2, listElementsProcessed.get("product_id"));
        Assert.assertEquals(337.21, listElementsProcessed.get("product_value"));
    }

}