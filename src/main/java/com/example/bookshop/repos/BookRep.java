package com.example.bookshop.repos;

import com.example.bookshop.domain.Book;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRep extends CrudRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByName(String name);
}