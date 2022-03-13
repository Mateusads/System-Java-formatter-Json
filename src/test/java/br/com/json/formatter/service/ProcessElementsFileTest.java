package br.com.json.formatter.service;

import org.junit.Assert;
import org.junit.Test;

public class ProcessElementsFileTest {

    @Test
    public void testProcessingElements(){
        SeparatingElementsFile separating = new SeparatingElementsFile();
        ProcessElementsFile process = new ProcessElementsFile();
        var listElements = (separating.separatingElements("0000000071                               Everett Beahan00000007590000000002      337.2120210808"));
        var listElementsProcess = process.processingElements(listElements);
        Assert.assertEquals(71, listElementsProcess.get("user_id"));
        Assert.assertEquals("Everett Beahan", listElementsProcess.get("user_name"));
        Assert.assertEquals(759, listElementsProcess.get("order_id"));
        Assert.assertEquals("2021-08-08", listElementsProcess.get("order_date").toString());
        Assert.assertEquals(2, listElementsProcess.get("product_id"));
        Assert.assertEquals(337.21, listElementsProcess.get("product_value"));
    }

}