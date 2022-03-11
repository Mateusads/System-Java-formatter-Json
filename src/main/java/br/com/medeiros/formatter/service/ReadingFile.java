package br.com.medeiros.formatter.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class ReadingFile {

    public Set<String> readingTheLines(){
        String filePath = ".src/main/resource/fileData.txt";
        String line = null;
        Set<String> lineList = new HashSet<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                lineList.add(line);
            }
        } catch (FileNotFoundException f){
            System.out.println(filePath + " does not exist");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineList;
    }

}
