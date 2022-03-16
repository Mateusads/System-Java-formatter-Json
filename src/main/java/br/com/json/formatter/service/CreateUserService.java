package br.com.json.formatter.service;

import br.com.json.formatter.model.Order;
import br.com.json.formatter.model.User;

import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class CreateUserService {

    public User createUser(int id, String name, Set<User> users){
        var newUser = createNewUser(id, name);
        if(users.contains(newUser)) return existingUser(id, users);
        return newUser;
    }

    private User existingUser(int id, Set<User> users) {
        AtomicReference<User> existentUser = new AtomicReference<>();
        users.iterator().forEachRemaining(user ->{
            if(user.getId() == id) existentUser.set(user);
        });
        return existentUser.get();
    }

    private User createNewUser(int id, String name){
        return User.builder()
                .id(id)
                .name(name)
                .build();
    }
}
