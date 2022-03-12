package br.com.json.formatter.model;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
public class Order {

    private int id;
    private double total;
    private LocalDate date;
    private User user;
    private Set<Product> products;
}
