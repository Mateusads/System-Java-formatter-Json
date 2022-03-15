package br.com.json.formatter.service;

import br.com.json.formatter.model.User;

import java.util.Set;

public class CreateUserService {

    public User createUser(int id, String name, Set<User> users){
        var newUser = existingUser(id, users);
        if(newUser == null) newUser = createNewUser(id, name);
        return newUser;
    }

    private User existingUser(int id, Set<User> users) {
        if(users != null){
            for(var user : users){
                if(user.getId() == id) return user;
            }
        }
        return null;
    }

    private User createNewUser(int id, String name){
        return User.builder()
                .id(id)
                .name(name)
                .build();
    }
}
