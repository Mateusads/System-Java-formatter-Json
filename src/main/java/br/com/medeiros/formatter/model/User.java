package br.com.medeiros.formatter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Entity;
import java.util.List;

@Builder
@AllArgsConstructor
@Entity
public class User {

    private int id;
    private String name;
    private List<Order> orders;

}
