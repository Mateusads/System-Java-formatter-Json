package br.com.medeiros.formatter.model;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
public class Product {

    private int id;
    private double value;
    private Order order;

}
