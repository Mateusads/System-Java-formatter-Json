package br.com.json.formatter.controller;

public class RequestFileConverter {

    public String readingFile(String path){
        ResponseToJson responseToJson = new ResponseToJson();
        return responseToJson.responseJson(path);
    }

}
