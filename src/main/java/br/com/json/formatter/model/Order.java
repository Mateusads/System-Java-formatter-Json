package br.com.json.formatter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {
    @EqualsAndHashCode.Include
    private int id;
    private double total;
    private LocalDate date;
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
