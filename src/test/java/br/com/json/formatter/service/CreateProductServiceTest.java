package br.com.json.formatter.service;

import br.com.json.formatter.model.Product;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateProductServiceTest{

    private static String LINE1 = "0000000071                               Everett Beahan00000007610000000004     1881.5420210702";
    private static String LINE2 = "0000000071                               Everett Beahan00000007610000000004     1881.5420210702";
    private static String LINE3 = "0000000057                          Elidia Gulgowski IV00000006200000000000     1417.2520210919";
    private static String LINE4 = "0000000057                          Elidia Gulgowski IV00000006200000000000     100.02520210919";

    @Test
    public void testCreatingEntityProduct(){
        CreateProductService createProductService = new CreateProductService();
        ExtractDataService extractDataService = new ExtractDataService();
        Set<Product> products = new HashSet<>();
        var createProducts = createProductService.createProduct(extractDataService.extractProductId(LINE1), extractDataService.extractProductValue(LINE1), products);

        assertThat(4).isEqualTo(createProducts.getId());
        assertThat(1881.54).isEqualTo(createProducts.getValue());
    }

    @Test
    public void testCreatingEntityUserMultipleLines(){
        CreateProductService createProductService = new CreateProductService();
        ExtractDataService extractDataService = new ExtractDataService();
        List<String> lines = new ArrayList<>();
        Set<Product> products = new LinkedHashSet<>();
        List<Product> productList = new ArrayList<>();
        lines.add(LINE1);
        lines.add(LINE2);
        lines.add(LINE3);
        lines.add(LINE4);
        for(var line : lines){
            var createdProduct = createProductService.createProduct(extractDataService.extractProductId(line), extractDataService.extractProductValue(line), products);
            products.add(createdProduct);
            productList.add(createdProduct);
        }

        assertThat(4).isEqualTo(productList.get(0).getId());
        assertThat(1881.54).isEqualTo(productList.get(0).getValue());
        assertThat(4).isEqualTo(productList.get(1).getId());
        assertThat(1881.54).isEqualTo(productList.get(1).getValue());
        assertThat(0).isEqualTo(productList.get(2).getId());
        assertThat(1417.25).isEqualTo(productList.get(2).getValue());
        assertThat(0).isEqualTo(productList.get(3).getId());
        assertThat(100.025).isEqualTo(productList.get(3).getValue());
    }
}