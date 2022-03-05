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
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private static final String BOOKS = "books";
    private final BookService bookService;
    
    @GetMapping
    public String book(@RequestParam(required = false, defaultValue = "") String filter, Model model) 
    {   
        if(filter != null && !filter.isEmpty()) {
            model.addAttribute(BOOKS, bookService.findByName(filter));
        }
        else {
            model.addAttribute(BOOKS, bookService.findAll());
        }

        model.addAttribute("filter", filter);

        return "book";
    }

    @PostMapping
    public String add(BookDto bookDto, Model model) {
        bookService.save(bookDto);

        model.addAttribute(BOOKS, bookService.findAll());
        model.addAttribute("filter", "");

        return "book";
    }
}
