package com.example.bookshop.mapper;

import com.example.bookshop.dto.BookDto;
import com.example.bookshop.entity.Book;

public class BookMapperImpl implements BookMapper {
    @Override
    public BookDto bookToBookDto(Book book) {
        if(book == null)
            return null;
        
        BookDto bookDto = new BookDto();

        bookDto.setName(book.getName());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setCount(book.getCount());

        return bookDto;
    }

    @Override
    public Book bookDtoToBook(BookDto bookDto) {
        if(bookDto == null)
            return null;
        
        Book book = new Book();

        book.setName(bookDto.getName());
        book.setAuthor(bookDto.getAuthor());
        book.setCount(bookDto.getCount());

        return book;
    }
}
