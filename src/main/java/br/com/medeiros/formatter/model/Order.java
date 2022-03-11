package br.com.medeiros.formatter.model;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
public class Order {

    private int id;
    private double total;
    private LocalDate date;
    private User user;
    private Set<Product> products;
}
