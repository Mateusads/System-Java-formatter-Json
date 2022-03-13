package br.com.json.formatter.service;

import br.com.json.formatter.model.Product;

import java.util.Set;

public class CreateProductService {

    private Product createProduct(int id, double value, Set<Product> products){
        var newProduct = existingProduct(id, products);
        if(newProduct == null) newProduct = createNewProduct(id, value);
        return newProduct;
    }

    private Product existingProduct(int id, Set<Product> products) {
        for(var product : products){
            if(product.getId() == id) return product;
        }
        return null;
    }

    private Product createNewProduct(int id, double value) {
        return Product.builder()
                .id(id)
                .value(value)
                .build();
    }
}
