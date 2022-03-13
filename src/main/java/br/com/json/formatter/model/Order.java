package br.com.json.formatter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Builder
public class Order {

    private int id;
    private double total;
    private LocalDate date;
    private List<Product> products;

    public void addingProductsInlist(Product newProduct){
        if(products == null) products = new ArrayList<>();
        this.products.add(newProduct);
    }

    public void addingValueInTotal(Double value){
        total += value;
    }
}
