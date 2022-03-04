package com.example.bookshop.controller;

import java.util.Objects;

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
    private static final String MESSAGE = "message";
    private static final String REGISTRATION = "registration";
    private final UserService userService;

    @GetMapping
    public String registration(Model model) {
        model.addAttribute(MESSAGE, "");

        return REGISTRATION;
    }
    
    @PostMapping
    public String addUser(UserDto userDto, Model model) {
        if(Objects.equals(userDto.getUsername(), "") || Objects.equals(userDto.getPassword(), "")) {
            model.addAttribute(MESSAGE, "Some field is empty.");
            return REGISTRATION;
        }

        if(userService.findByUsername(userDto.getUsername()).isPresent()) {
            model.addAttribute(MESSAGE, "Account exists.");
            return REGISTRATION;
        }


        userService.save(userDto);

        return "redirect:/login";
    }
}
