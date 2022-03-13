package br.com.json.formatter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Getter
@Builder
public class Order {

    private int id;
    private double total;
    private LocalDate date;
    private User user;
    private Set<Product> products;
}
