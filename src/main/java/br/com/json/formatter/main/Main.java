package br.com.json.formatter.main;

import br.com.json.formatter.controller.RequestFileConverter;

public class Main {

    public static void main(String[] args) {
        String path = "./src/fileDataTest.txt";
        if(args != null && args.length > 0) {
            path = args[0];
        }
        RequestFileConverter requestFileConverter = new RequestFileConverter();
        var jsonTheFile= requestFileConverter.readingFile(path);
        System.out.println(jsonTheFile);

    }
}
