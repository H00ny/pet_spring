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

import java.util.Optional;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
  private static final String BOOKS = "books";
  private final BookService bookService;

  @GetMapping
  public String getAllBook(BookFilter filter, Model model) {
    Optional.ofNullable(filter)
        .ifPresentOrElse(
            existFilter -> model.addAttribute(BOOKS, bookService.findByFilter(existFilter)),
            () -> model.addAttribute(BOOKS, bookService.findAll()));

    model.addAttribute("filter", filter);

    return "book";
  }

  @PostMapping
  public String savedBook(BookDto bookDto, Model model) {
    bookService.saveBook(bookDto);
    
    model.addAttribute(BOOKS, bookService.findAll());
    model.addAttribute("filter", "");

    return "book";
  }
}
