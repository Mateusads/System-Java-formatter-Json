package br.com.json.formatter.main;

import br.com.json.formatter.controller.RequestFileConverter;

public class Main {

    public static void main(String[] args) {

        try {
            var path = args[0];
            RequestFileConverter requestFileConverter = new RequestFileConverter();
            var jsonTheFile = requestFileConverter.readingFile(path);
            System.out.println(jsonTheFile);
            System.out.println("200: Program finished");
        }catch (NullPointerException e ){
            System.out.println("500: Error: " + e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("404: Path not found");
        }
    }
}
