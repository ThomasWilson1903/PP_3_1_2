package com.example.pp_3_1_2.controller;

import com.example.pp_3_1_2.model.User;
import com.example.pp_3_1_2.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.script.Bindings;

@Controller
@RequestMapping("/user")
public class UserController {

    UserServices userServices;
    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping()
    public String show(Model model) {
        model.addAttribute("user", userServices.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public User showId(@PathVariable("id") int id) {
        return userServices.getUser(id);
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "newUser";
    }

    @GetMapping ("/save")
    public String saveUser(@Valid User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("newUser", new User());
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "newUser";
        }
        userServices.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/del")
    public String del(@RequestParam("id") int id) {
        userServices.deleteUser(id);
        return "redirect:/user";
    }
}
