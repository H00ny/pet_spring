package com.example.bookshop.service;

import java.util.List;

import com.example.bookshop.dto.BookDto;
import com.example.bookshop.entity.Book;
import com.example.bookshop.mapper.BookMapper;
import com.example.bookshop.mapper.UserMapper;
import com.example.bookshop.repository.BookRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private BookMapper bookMapper;
    
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
    public List<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void save(BookDto bookDto) {
        bookRepository.save(bookMapper.bookDtoToBook(bookDto));
    }
}
