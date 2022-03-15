package com.example.bookshop.controller;

import com.example.bookshop.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping
  public String getAllBook(Model model) {
    model.addAttribute("users", userService.findAll());
    return "users";
  }
}
