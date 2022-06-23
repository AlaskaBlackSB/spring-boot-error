package com.example.error.springbooterror.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.error.springbooterror.models.User;

@Service
public class UserServiceImplement implements UserService {

    private List<User> users;

    public UserServiceImplement() {
        this.users = Arrays.asList(
                new User(1, "John", "Kenedy"),
                new User(2, "Agner", "Amador"),
                new User(3, "Alexis", "Plascencia"),
                new User(4, "Lucero", "Jimenez"));
    }

    @Override
    public List<User> all() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User find(Integer id) {
        User user = null;

        for (User u : this.users) {
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }

        return user;
    }

    @Override
    public Optional<User> findOptional(Integer id) {
        User user = this.find(id);

        // Convierte el modelo usuario a tipo Optional
        return Optional.ofNullable(user);
    }

}