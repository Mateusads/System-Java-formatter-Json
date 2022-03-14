package br.com.json.formatter.controller;

import br.com.json.formatter.model.User;
import br.com.json.formatter.service.ReadingFileService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Set;

public class ResponseToJson {

    public String responseJson(String path){
        ReadingFileService readingFileService = new ReadingFileService();
        return createDataForJson(readingFileService.readingFile(path));
    }
    private String createDataForJson(Set<User> usersCreated){
        Gson userJson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        StringBuilder userResponse = new StringBuilder();
        for(var user : usersCreated){
            userResponse.append(userJson.toJson(user));
        }
        return userResponse.toString();
    }
}
