package br.com.json.formatter.service;

import java.time.LocalDate;

public class ProcessElementsService {

    public int transformeStringToInt(String textInt) {
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

    public LocalDate transformeStringToDate(String textDate) {
        LocalDate transformedDate = LocalDate.of(Integer.parseInt(textDate.substring(0,4)),
                Integer.parseInt(textDate.substring(4,6)),
                Integer.parseInt(textDate.substring(6,8)));
        return transformedDate;
    }

    public Double transformeStringToDouble(String textDouble) {
        return Double.parseDouble(textDouble);
    }

}
