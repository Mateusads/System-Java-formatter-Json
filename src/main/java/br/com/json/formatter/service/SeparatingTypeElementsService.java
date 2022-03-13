package br.com.json.formatter.service;

import java.util.ArrayList;
import java.util.List;

public class SeparatingTypeElementsService {

    public List<String> separatingElements(String listaElements){
        List<String> elementsByType = new ArrayList<>();
        try{
            elementsByType.add(listaElements.substring(0,10));
            elementsByType.add(listaElements.substring(11, 55).trim());
            elementsByType.add(listaElements.substring(55, 65));
            elementsByType.add(listaElements.substring(65, 75));
            elementsByType.add(listaElements.substring(76, 87).trim());
            elementsByType.add(listaElements.substring(87, 95));
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return elementsByType;
    }

}
