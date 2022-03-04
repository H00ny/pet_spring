package com.example.bookshop.controller;

import java.util.Objects;

import com.example.bookshop.dto.UserDto;
import com.example.bookshop.service.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    private String message = "message";
    private String registration = "registration";

    @GetMapping
    public String registration(Model model) {
        model.addAttribute(message, "");

        return registration;
    }
    
    @PostMapping
    public String addUser(UserDto userDto, Model model) {
        // if(Objects.equals(userDto.getUsername(), "") || Objects.equals(userDto.getPassword(), "")) {
        //     model.addAttribute(message, "Some field is empty.");
        //     return registration;
        // }

        // if(userService.findByUsername(userDto) != null) {
        //     model.addAttribute(message, "Account exists.");
        //     return registration;
        // }

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userService.save(userDto);

        return "redirect:/login";
    }
}
