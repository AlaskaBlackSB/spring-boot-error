package com.example.error.springbooterror.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.error.springbooterror.errors.UserNotFoundException;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ArithmeticException.class)
    public String ArithmeticError(ArithmeticException ex, Model model) {
        model.addAttribute("error", "Error de aritmética");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        return "error/arithmetic";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String ArithmeticError(NumberFormatException ex, Model model) {
        model.addAttribute("error", "Error de formato númerico");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        return "error/numberFormat";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String UserNotFound(UserNotFoundException ex, Model model) {
        model.addAttribute("error", "Error: el usuario no existe.");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        return "error/UserNotFoundException";
    }

}