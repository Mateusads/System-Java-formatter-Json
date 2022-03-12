package br.com.json.formatter.service;

import java.util.HashMap;
import java.util.Map;

public class SeparatingElementsFile {

    public static Map<String, String> separatingElements(String listaElements){
        Map<String, String> mapElements = new HashMap<>();
        mapElements.put("user_id", listaElements.substring(0,10));
        mapElements.put("user_name", listaElements.substring(11, 55).trim());
        mapElements.put("order_id", listaElements.substring(55, 65));
        mapElements.put("product_id", listaElements.substring(65, 75));
        mapElements.put("product_value", listaElements.substring(76, 87).trim());
        mapElements.put("order_date", listaElements.substring(87, 95));
        return mapElements;
    }

}
