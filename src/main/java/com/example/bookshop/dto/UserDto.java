package com.example.bookshop.dto;

import java.util.Set;

import javax.validation.constraints.NotNull;

import com.example.bookshop.entity.Role;

import lombok.Data;

@Data
public class UserDto {
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private Set<Role> roles;
}