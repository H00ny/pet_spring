package com.example.bookshop.controller;

import com.example.bookshop.dto.BookDto;
import com.example.bookshop.service.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {
    private final BookService bookService;
    private String books = "books";

    @GetMapping
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) 
    {   
        if(filter != null && !filter.isEmpty())
            model.addAttribute(books, bookService.findByName(filter));
        else
            model.addAttribute(books, bookService.findAll());

        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping
    public String add(BookDto bookDto, Model model) {
        bookService.save(bookDto);

        model.addAttribute(books, bookService.findAll());
        model.addAttribute("filter", "");

        return "main";
    }
}
