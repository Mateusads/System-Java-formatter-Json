package br.com.json.formatter.service;

import java.util.Map;

public class ProcessElementsFile {

    public void processingElements(Map<String, String> elementsMap){
        elementsMap.put("user_id", removingZeros(elementsMap.get("user_id")));
        elementsMap.put("order_id", removingZeros(elementsMap.get("order_id")));
        elementsMap.put("product_id", removingZeros(elementsMap.get("product_id")));
    }

    private String removingZeros(String element) {
        int index = 0;
        for(int i = 0; i < element.length(); i++){
            var itemElement = element.charAt(i);
            if (itemElement != '0'){
                index = i;
                break;
            }
        }
        return element.substring(index, element.length());
    }

}
