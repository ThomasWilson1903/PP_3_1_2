package com.example.pp_3_1_2.controller;

import com.example.pp_3_1_2.model.User;
import com.example.pp_3_1_2.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;


    @GetMapping()
    public List<User> show() {
        return userServices.getAllUsers();
    }

    @GetMapping("/{id}")
    public User showId(@PathVariable("id") int id) {
        return userServices.getUser(id);
    }

    @PostMapping("/save")
    public void saveUser(@RequestParam(name = "name", required = true) String name, @RequestParam(name = "surname", required = true) String surName, @RequestParam(name = "email", required = true) String email) {
        User user = new User();
        user.setEmail(email);
        user.setFirstName(name);
        user.setLastName(surName);
        userServices.saveUser(user);
    }

    @PostMapping("/del/{id}")
    public void del(@PathVariable("id") int id) {
        userServices.deleteUser(id);
    }

}
