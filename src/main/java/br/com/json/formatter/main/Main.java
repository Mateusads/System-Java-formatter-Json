package br.com.json.formatter.main;

import br.com.json.formatter.controller.RequestFileConverter;

public class Main {

    public static void main(String[] args) {

        try {
            var path = args[0];
            RequestFileConverter requestFileConverter = new RequestFileConverter();
            var jsonTheFile = requestFileConverter.readingFile(path);
            System.out.println(jsonTheFile);
        }catch (NullPointerException e ){
            System.out.println("Error: " + e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Path not found");
            System.out.println("Error: " + e.getMessage());
        }finally {
            System.out.println("Program closed");
        }
    }
}
