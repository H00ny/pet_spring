package com.example.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {
  @GetMapping
  public String login(
      @RequestParam(value = "error", required = false) String error,
      @RequestParam(value = "logout", required = false) String logout,
      Model model) {
    Optional.ofNullable(error)
            .ifPresent(message -> model.addAttribute("error", "Wrong username or password!"));
    Optional.ofNullable(logout)
            .ifPresent(message -> model.addAttribute("logout", "You have successfully logged out."));

    return "login";
  }
}
