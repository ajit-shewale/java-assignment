package com.springWeb2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springWeb2.entity.User;
import com.springWeb2.service.UserDetailsServiceImpl;

@Controller
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping(value = "/newUserForm")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newUserForm";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userDetailsServiceImpl.saveUser(user);
        return "redirect:/login";
    }
}
