package br.com.json.formatter.controller;

import br.com.json.formatter.service.ReadingFileService;

public class RequestFileConverter {

    public String readingFile(String path){
        ResponseToJson responseToJson = new ResponseToJson();
        return responseToJson.responseJson(path);
    }

}
