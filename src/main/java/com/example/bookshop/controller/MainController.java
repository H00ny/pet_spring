package com.example.bookshop.controller;

import com.example.bookshop.entity.Book;
import com.example.bookshop.service.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {
    private final BookService bookService;

    @GetMapping
    public String main(Model model) {
        model.addAttribute("books", bookService.findAll());

        return "main";
    }

    @PostMapping
    public String add(Book book, Model model) {
        bookService.save(book);

        model.addAttribute("books", bookService.findAll());
        
        return "main";
    }
}
