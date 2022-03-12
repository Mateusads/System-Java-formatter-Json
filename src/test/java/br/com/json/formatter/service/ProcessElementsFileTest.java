package br.com.json.formatter.service;

import org.junit.Assert;
import org.junit.Test;

public class ProcessElementsFileTest {

    @Test
    public void testProcessingElements(){
        SeparatingElementsFile separating = new SeparatingElementsFile();
        ProcessElementsFile process = new ProcessElementsFile();
        var listElements = (separating.separatingElements("0000000071                               Everett Beahan00000007590000000002      337.2120210808"));
        process.processingElements(listElements);
        Assert.assertEquals("71", listElements.get("user_id"));
        Assert.assertEquals("759", listElements.get("order_id"));
        Assert.assertEquals("2", listElements.get("product_id"));

    }
}