package com.example.bookshop.repository.book;

import java.util.List;

import com.example.bookshop.entity.Book;
import com.example.bookshop.filter.BookFilter;

public interface CustomBookRepository {
    List<Book> findByFilter(BookFilter filter);
}
