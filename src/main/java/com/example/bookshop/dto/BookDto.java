package com.example.bookshop.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BookDto {
    @NotNull
    @Size(min = 1, max = 128)
    private String name;

    @NotNull
    @Size(min = 1, max = 32)
    private String author;

    @NotNull
    @PositiveOrZero
    private Integer count;
}
