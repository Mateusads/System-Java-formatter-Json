package br.com.json.formatter.service;

import java.time.LocalDate;

import static br.com.json.formatter.service.enums.IndexConverter.*;

public class ExtractDataService {

    public int extractUserId(String line) {
        return Integer.parseInt((constructTextConverter(line, INDEX_IDUSER_START.getValue(), INDEX_IDUSER_END.getValue())).trim());
    }

    public String extractName(String line) {
        return constructTextConverter(line, INDEX_NAMEUSER_START.getValue(), INDEX_NAMEUSER_END.getValue()).trim();
    }

    public int extractOrderId(String line) {
        return Integer.parseInt(constructTextConverter(line, INDEX_IDORDER_START.getValue(), INDEX_IDORDER_END.getValue()).trim());
    }

    public int extractProductId(String line) {
        return Integer.parseInt(constructTextConverter(line, INDEX_IDPRODUCT_START.getValue(), INDEX_IDPRODUCT_END.getValue()).trim());
    }

    public double extractProductValue(String line) {
        return Double.parseDouble(constructTextConverter(line, INDEX_VALUEPRODUCT_START.getValue(), INDEX_VALUEPRODUCT_END.getValue()).trim());
    }

    public LocalDate extractOrderDate(String line) {
        String lineDate = constructTextConverter(line, INDEX_DATEORDER_START.getValue(), INDEX_DATEORDER_END.getValue()).trim();
        if(lineDate.length() >= 8){
            LocalDate transformedDate = LocalDate.of(Integer.parseInt(lineDate.substring(0, 4)),
                    Integer.parseInt(lineDate.substring(4, 6)),
                    Integer.parseInt(lineDate.substring(6, 8)));
            return transformedDate;
        }
        return LocalDate.now();
    }

    private String constructTextConverter(String line, int indexStart, int indexEnd) {
        if(line.length() < indexEnd){
            return indexStart > line.length() ? line.substring(indexStart, line.length()) : "0";
        }else
            return line.substring(indexStart, indexEnd);
    }
}