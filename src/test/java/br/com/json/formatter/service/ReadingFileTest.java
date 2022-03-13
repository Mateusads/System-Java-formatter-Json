package br.com.json.formatter.service;

import org.junit.Assert;
import org.junit.Test;

public class ReadingFileTest {

    @Test
    public void readFileReturnLine(){ ;
        ReadingFile readFile = new ReadingFile();
        var linesFile= readFile.readingFile("./src/fileDataTest.txt");

        Assert.assertEquals("[0000000075                                  Bobbie Batz00000007980000000002     1578.5720211116, " +
                "0000000049                               Ken Wintheiser00000005230000000003      586.7420210903]", linesFile.toString());
    }

}