package com.example.bookshop.service;

import java.util.List;
import java.util.Optional;

import com.example.bookshop.dto.BookDto;
import com.example.bookshop.mapper.BookMapper;
import com.example.bookshop.repository.BookRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    
    public List<BookDto> findByName(String name) {
        return bookRepository
                .findByName(name)
                .stream()
                    .map(bookMapper::booktoBookDto)
                    .toList();
    }

    public List<BookDto> findAll() {
        return bookRepository
                .findAll()
                .stream()
                    .map(bookMapper::booktoBookDto)
                    .toList();
    }

    public Optional<BookDto> save(BookDto bookDto) {
        return Optional
                .ofNullable(bookRepository.save(bookMapper.bookDtoToBook(bookDto)))
                .map(bookMapper::booktoBookDto);
    }
}
