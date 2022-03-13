package br.com.json.formatter.service;


import org.junit.Assert;
import org.junit.Test;

public class SeparatingTypeElementsServiceTest {

    @Test
    public void SeparatingElementTest(){
        String lineFile = "0000000070                              Palmer Prosacco00000007530000000003     1836.7420210308";
        SeparatingTypeElementsService elementsFile = new SeparatingTypeElementsService();
        var listElements = elementsFile.separatingElements(lineFile);
        Assert.assertEquals("0000000070", listElements.get(0));
        Assert.assertEquals("Palmer Prosacco", listElements.get(1));
        Assert.assertEquals("0000000753", listElements.get(2));
        Assert.assertEquals("0000000003", listElements.get(3));
        Assert.assertEquals("1836.74", listElements.get(4));
        Assert.assertEquals("20210308", listElements.get(5));

    }


}