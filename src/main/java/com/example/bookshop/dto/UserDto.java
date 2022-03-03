package com.example.bookshop.dto;

import java.util.Set;

import javax.validation.constraints.NotNull;

import com.example.bookshop.entity.Role;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private Set<Role> roles;
}
