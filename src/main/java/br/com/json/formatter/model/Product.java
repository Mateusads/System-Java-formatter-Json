package br.com.json.formatter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Product {

    private int id;
    private double value;

}
