package com.example.bookshop.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.bookshop.entity.Book;
import com.example.bookshop.filter.BookFilter;

public interface BookRepository extends JpaRepository<Book, Long>, CustomBookRepository {
  List<Book> findByFilter(BookFilter bookFilter);
}
