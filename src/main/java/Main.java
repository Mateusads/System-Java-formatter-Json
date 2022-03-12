import br.com.json.formatter.service.ReadingFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        ReadingFile readingFile = new ReadingFile();
        var linesFile= readingFile.readingFile("./src/fileData.txt");
        linesFile.forEach(line -> System.out.println(line));
    }





}
