package com.example.error.springbooterror.errors;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String id) {
        super("El usuario con id ".concat(id).concat(" no existe en el sistema."));
    }

}