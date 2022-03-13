package br.com.json.formatter.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public Date transformeStringToDate(String textDate) {
        Date dataFormatada = new Date();
        try{
            SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
            dataFormatada = formato.parse(textDate);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return dataFormatada;
    }

    public Double transformeStringToDouble(String textDouble) {
        return Double.parseDouble(textDouble);
    }

}
