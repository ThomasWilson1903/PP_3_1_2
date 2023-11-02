package com.example.pp_3_1_2.controller;

import com.example.pp_3_1_2.model.User;
import com.example.pp_3_1_2.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;


    @GetMapping()
    public String show(Model model) {
        model.addAttribute("user", userServices.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public User showId(@PathVariable("id") int id) {
        return userServices.getUser(id);
    }

    @GetMapping ("/new")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "newUser";
    }

    @GetMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userServices.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/del")
    public String del(@RequestParam("id") int id) {
        userServices.deleteUser(id);
        return "redirect:/user";
    }
}
