package com.example.bookshop.controllers;

import com.example.bookshop.domain.Book;
import com.example.bookshop.repos.BookRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private BookRep bookRep;

    @GetMapping("/")
    public String start() {
        return "start";
    }

    @GetMapping("/main")
    public String main(Model model) {
        Iterable<Book> books = bookRep.findAll();

        model.addAttribute("books", books);

        return "main";
    }

    @PostMapping("/main")
    public String add(
        @RequestParam String name, 
        @RequestParam String author,
        @RequestParam String count,
        Model model
    ) {
        Book book = new Book(name, author, count);

        bookRep.save(book);

        Iterable<Book> books = bookRep.findAll();

        model.addAttribute("books", books);

        return "main";
    }
}
