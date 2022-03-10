package com.example.bookshop.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String name;
    private String author;
    private Integer count;
}
