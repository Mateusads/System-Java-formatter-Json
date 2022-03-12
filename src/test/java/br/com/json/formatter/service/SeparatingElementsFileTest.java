package br.com.json.formatter.service;


import org.junit.Assert;
import org.junit.Test;

public class SeparatingElementsFileTest {

    @Test
    public void SeparatingElementTest(){
        String lineFile = "0000000070                              Palmer Prosacco00000007530000000003     1836.7420210308";
        SeparatingElementsFile elementsFile = new SeparatingElementsFile();
        var listElements = elementsFile.separatingElements(lineFile);
        Assert.assertEquals("0000000070", listElements.get("user_id"));
        Assert.assertEquals("Palmer Prosacco", listElements.get("user_name"));
        Assert.assertEquals("0000000753", listElements.get("order_id"));
        Assert.assertEquals("0000000003", listElements.get("product_id"));
        Assert.assertEquals("1836.74", listElements.get("product_value"));
        Assert.assertEquals("20210308", listElements.get("order_date"));

    }


}