package com.example.bookshop.controllers;

import java.util.Collections;

import com.example.bookshop.domain.Role;
import com.example.bookshop.domain.User;
import com.example.bookshop.repos.UserRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {
    @Autowired
    UserRep userRep;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
    
    @PostMapping(value="/registration")
    public String addUser(User user, Model model) {
        User userFromDb = userRep.findByUsername(user.getUsername());

        if(userFromDb != null) {
            model.addAttribute("message", "Account exists.");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRep.save(user);
        
        return "redirect:/login";
    }
}
