package br.com.json.formatter.service;

import org.junit.Assert;
import org.junit.Test;

public class ReadingFileTest {

    @Test
    public void readFileReturnLine(){ ;
        ReadingFile readingFile = new ReadingFile();
        var linesFile= readingFile.readingFile("./src/fileData.txt");
        linesFile.forEach(line -> System.out.println(line));

        Assert.assertEquals("[0000000070                              Palmer Prosacco00000007530000000003     1836.7420210308]", linesFile.toString());
    }

}