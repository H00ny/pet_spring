package com.example.bookshop.mapper;

import com.example.bookshop.dto.UserDto;
import com.example.bookshop.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper
public abstract class UserMapper {
  @Autowired protected PasswordEncoder passwordEncoder;

  @Mappings({
    @Mapping(target = "active", constant = "true"),
    @Mapping(
        target = "password",
        expression = "java(passwordEncoder.encode(userDto.getPassword()))"),
    @Mapping(
        target = "roles",
        expression = "java(java.util.Collections.singleton(com.example.bookshop.entity.Role.USER))")
  })
  public abstract User userDtoToUser(UserDto userDto);

  public abstract UserDto userToUserDto(User user);
}
