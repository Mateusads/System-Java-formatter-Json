package br.com.json.formatter.controller;

import br.com.json.formatter.model.User;
import br.com.json.formatter.service.ReadingFileService;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ResponseToJson {

    public String responseJson(String path){
        ReadingFileService readingFileService = new ReadingFileService();
        return createDataForJson(readingFileService.readingFile(path));
    }

    private String createDataForJson(Set<User> usersCreated){
        Gson userJson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        StringBuilder userResponse = new StringBuilder();
        userResponse.append(userJson.toJson(usersCreated));
        return userResponse.toString();
    }

    private class LocalDateAdapter implements JsonSerializer<LocalDate> {
        public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
        }
    }
}
