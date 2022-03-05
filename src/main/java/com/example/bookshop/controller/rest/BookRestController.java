package com.example.bookshop.controller.rest;

import java.util.List;

import com.example.bookshop.dto.BookDto;
import com.example.bookshop.filter.BookFilter;
import com.example.bookshop.service.BookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/book")
public class BookRestController {
    private final BookService bookService;
    
    @GetMapping()
    public List<BookDto> bookFilter(BookFilter bookFilter) {    
        return bookService.findByFilter(bookFilter);
    }

    @PostMapping
    public BookDto add(@RequestBody BookDto bookDto) {
        bookService.save(bookDto);

        return bookDto;
    }
}
