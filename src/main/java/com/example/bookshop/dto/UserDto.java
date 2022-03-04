package com.example.bookshop.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDto {
    @NotNull
    @Size(min = 4, max = 64)
    private String username;

    @NotNull
    @Size(min = 4, max = 32)
    private String password;
}