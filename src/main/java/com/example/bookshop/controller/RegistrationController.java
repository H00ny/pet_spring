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

    private String msg = "message";
    private String reg = "registration";

    @GetMapping
    public String registration(Model model) {
        model.addAttribute(msg, "");

        return reg;
    }
    
    @PostMapping
    public String addUser(UserDto userDto, Model model) {
        if(Objects.equals(userDto.getUsername(), "") || Objects.equals(userDto.getPassword(), "")) {
            model.addAttribute(msg, "Some field is empty.");
            return reg;
        }

        if(userService.findByUsername(userDto) != null) {
            model.addAttribute(msg, "Account exists.");
            return reg;
        }

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userService.save(userDto);

        return "redirect:/login";
    }
}
