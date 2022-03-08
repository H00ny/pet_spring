package com.example.bookshop.controller;

import com.example.bookshop.dto.UserDto;
import com.example.bookshop.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @GetMapping
    public String registration(Model model) {
        model.addAttribute("message", "");

        return "registration";
    }
    
    @PostMapping
    public String addUser(UserDto userDto) {
        userService.save(userDto);

        return "redirect:/login";
    }
}
