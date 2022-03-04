package com.example.bookshop.mapper;

import com.example.bookshop.dto.BookDto;
import com.example.bookshop.entity.Book;

import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    BookDto bookToBookDto(Book book);
    Book bookDtoToBook(BookDto bookDto);
}
