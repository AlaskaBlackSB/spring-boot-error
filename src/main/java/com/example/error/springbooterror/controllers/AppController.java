package com.example.error.springbooterror.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.error.springbooterror.errors.UserNotFoundException;
import com.example.error.springbooterror.models.User;
import com.example.error.springbooterror.services.UserService;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(Model model) {
        // Genera un error 500 de tipo ArithmeticException
        // Integer valor = 100 / 0;
        Integer valor = Integer.parseInt("10xz");

        // Genera un error 500
        return "index";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        User user = userService.find(id);

        if (user == null) {
            throw new UserNotFoundException(id.toString());
        }

        model.addAttribute("user", user);
        model.addAttribute("titulo", "Detalle usuario: ".concat(user.getName()));
        return "show";
    }

    @GetMapping("/show-optional/{id}")
    public String showOptional(@PathVariable Integer id, Model model) {
        User user = userService.findOptional(id).orElseThrow(() -> new UserNotFoundException(id.toString()));

        model.addAttribute("user", user);
        model.addAttribute("titulo", "Detalle usuario: ".concat(user.getName()));
        return "show";
    }

}