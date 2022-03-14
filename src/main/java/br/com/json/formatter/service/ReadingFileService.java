package br.com.json.formatter.service;

import br.com.json.formatter.model.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReadingFileService {

    public Set<User> readingFile(String path) {
        String filePath = path;
        String line = null;
        List<String> lineList = new ArrayList<>();
        CreateObjects createObjects = new CreateObjects();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                lineList.add(line);
            }
        } catch (FileNotFoundException f) {
            System.out.println(filePath + " does not exist");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createObjects.createObjectFromLines(lineList);
    }
}