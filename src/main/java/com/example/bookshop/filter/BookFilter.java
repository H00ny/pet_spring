package com.example.bookshop.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookFilter {
    private String name;
    private String author;
    private Integer count;
}
