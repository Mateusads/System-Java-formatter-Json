package br.com.json.formatter.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ProcessElementsFile {

    public Map<String, Object> processingElements(Map<String, String> elementsMap){
        Map<String, Object> mapElements = new HashMap<>();
        mapElements.put("user_id", transformeStringToInt(elementsMap.get("user_id")));
        mapElements.put("user_name", elementsMap.get("user_name"));
        mapElements.put("order_id", transformeStringToInt(elementsMap.get("order_id")));
        mapElements.put("product_id", transformeStringToInt(elementsMap.get("product_id")));
        mapElements.put("product_value", transformeStringToDouble(elementsMap.get("product_value")));
        mapElements.put("order_date", transformeStringToDate(elementsMap.get("order_date")));
        return mapElements;
    }

    private int transformeStringToInt(String textInt) {
        var index = 0;
        for(int i = 0; i < textInt.length(); i++){
            var itemElement = textInt.charAt(i);
            if (itemElement != '0'){
                index = i;
                break;
            }
        }
        var transformedInt= Integer.parseInt(textInt.substring(index, textInt.length()));
        return transformedInt;
    }

    private LocalDate transformeStringToDate(String textDate) {
        LocalDate transformedDate = LocalDate.of(Integer.parseInt(textDate.substring(0,4)),
                Integer.parseInt(textDate.substring(4,6)),
                Integer.parseInt(textDate.substring(6,8)));
        return transformedDate;
    }

    private Object transformeStringToDouble(String textDouble) {
        return Double.parseDouble(textDouble);
    }

}
