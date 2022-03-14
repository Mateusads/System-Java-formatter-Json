package br.com.json.formatter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class User {

    private int id;
    private String name;
    private List<Order> orders;

    public User() {

    }

    public void addingOrdersInlist(Order newOrder){
        if(orders == null) orders = new ArrayList<>();
        if(!this.orders.contains(newOrder)) this.orders.add(newOrder);
    }
}
