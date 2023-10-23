package com.example.pp_3_1_2.controller;

import com.example.pp_3_1_2.model.User;
import com.example.pp_3_1_2.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServices userServices;


    @GetMapping("/user")
    public List<User> show() {
        return userServices.getAllUsers();
    }

   /* @GetMapping("/{id}")
    public String showId(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServices.getUser(id));
        return mainPage;
    }

    @PostMapping("/save")
    public String saveUser(
            @RequestParam(name = "name", required = true) String name,
            @RequestParam(name = "surname", required = true) String surName,
            @RequestParam(name = "email", required = true) String email
    ) {
        User user = new User();
        user.setEmail(email);
        user.setFirstName(name);
        user.setLastName(surName);
        userServices.saveUser(user);
        return mainPage;
    }

    @PostMapping("/del/{id}")
    public String del(@PathVariable("id") int id, Model model) {
        userServices.deleteUser(id);
        return mainPage;
    }*/

}
