package com.example.bookshop.dto;

import lombok.Data;

@Data
public class BookDto {
  private Long id;
  private String name;
  private String author;
  private Integer count;
}
