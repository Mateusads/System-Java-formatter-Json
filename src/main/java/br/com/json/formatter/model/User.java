package br.com.json.formatter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder
public class User {

    private int id;
    private String name;
    private List<Order> orders;
}
