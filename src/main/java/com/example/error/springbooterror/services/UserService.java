package com.example.error.springbooterror.services;

import java.util.List;
import java.util.Optional;

import com.example.error.springbooterror.models.User;

public interface UserService {

    public List<User> all();

    public User find(Integer id);

    public Optional<User> findOptional(Integer id);

}