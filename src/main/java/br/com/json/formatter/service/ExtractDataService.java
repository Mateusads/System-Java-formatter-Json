package br.com.json.formatter.service;

import java.time.DateTimeException;
import java.time.LocalDate;

public class ExtractDataService {

    public int extractUserId(String line) {
        return Integer.parseInt(line.substring(0,10));
    }

    public String extractName(String line) {
        return line.substring(11, 55).trim();
    }

    public int extractOrderId(String line) {
        return Integer.parseInt(line.substring(55, 65));
    }

    public int extractProductId(String line) {
        return Integer.parseInt(line.substring(65, 75));
    }

    public double extractProductValue(String line) {
        return Double.parseDouble(line.substring(76, 87).trim());
    }

    public LocalDate extractOrderDate(String line) {
        String lineDate = line.substring(87, 95);
        try{
            LocalDate transformedDate = LocalDate.of(Integer.parseInt(lineDate.substring(0, 4)),
                    Integer.parseInt(lineDate.substring(4, 6)),
                    Integer.parseInt(lineDate.substring(6, 8)));
            return transformedDate;
        }catch (DateTimeException e){
            System.out.println(e.getMessage());
        }
        return LocalDate.now();
    }
}
