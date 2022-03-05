package com.example.bookshop.controller;

import com.example.bookshop.dto.BookDto;
import com.example.bookshop.filter.BookFilter;
import com.example.bookshop.service.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private static final String BOOKS = "books";
    private final BookService bookService;
    
    @GetMapping
    public String book(BookFilter filter, Model model) 
    {   
        if(filter != null) {
            model.addAttribute(BOOKS, bookService.findByFilter(filter));
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
