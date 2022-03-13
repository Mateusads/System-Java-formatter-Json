package br.com.json.formatter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class Order {

    private int id;
    private double total;
    private Date date;
    private List<Product> products;

    public void addingProductsInlist(Product newProduct){
        if(products == null) products = new ArrayList<>();
        this.products.add(newProduct);
        addingValueInTotal(newProduct.getValue());
    }

    private void addingValueInTotal(Double value){
        total += value;
    }
}
