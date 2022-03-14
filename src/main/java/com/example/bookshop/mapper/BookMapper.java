package com.example.bookshop.mapper;

import com.example.bookshop.dto.BookDto;
import com.example.bookshop.entity.Book;

import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
  Book bookDtoToBook(BookDto bookDto);

  BookDto bookToBookDto(Book book);
}
