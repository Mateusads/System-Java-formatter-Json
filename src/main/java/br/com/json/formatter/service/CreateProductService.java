package br.com.json.formatter.service;

import br.com.json.formatter.model.Product;

import java.util.Set;

public class CreateProductService {

    public Product createProduct(int id, double value){
        return createNewProduct(id, value);
    }

    private Product createNewProduct(int id, double value) {
        return Product.builder()
                .id(id)
                .value(value)
                .build();
    }
}
