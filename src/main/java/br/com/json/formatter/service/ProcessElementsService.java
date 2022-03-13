package br.com.json.formatter.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessElementsService {

    public Map<String, Object> processingElements(List<String> elementsMap){
        Map<String, Object> mapElements = new HashMap<>();
        mapElements.put("user_id", transformeStringToInt(elementsMap.get(0)));
        mapElements.put("user_name", elementsMap.get(1));
        mapElements.put("order_id", transformeStringToInt(elementsMap.get(2)));
        mapElements.put("product_id", transformeStringToInt(elementsMap.get(3)));
        mapElements.put("product_value", transformeStringToDouble(elementsMap.get(4)));
        mapElements.put("order_date", transformeStringToDate(elementsMap.get(5)));
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
