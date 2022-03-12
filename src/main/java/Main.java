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
        if(args != null && args.length > 0){
            ReadingFile readingFile = new ReadingFile();
            String path = args[0];
            var linesFile= readingFile.readingFile(path);
            linesFile.forEach(line -> System.out.println(line));
        }else
            System.out.println("There is no file path...");
    }





}
