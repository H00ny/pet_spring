package com.example.bookshop.controller.rest;

import com.example.bookshop.service.BookService;

import java.util.List;

import com.example.bookshop.dto.BookDto;
import com.example.bookshop.entity.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/book")
public class BookRestController {
    private final BookService bookService;
    
    @GetMapping()
    public List<BookDto> bookFilter(@RequestParam(required = false, defaultValue = "") String filter) 
    {   
        if(filter != null && !filter.isEmpty()) {
            return bookService.findByName(filter);
        }
        else {
            return bookService.findAll();
        }
    }

    @PostMapping
    public BookDto add(@RequestBody BookDto bookDto) {
        bookService.save(bookDto);

        return bookDto;
    }
}
