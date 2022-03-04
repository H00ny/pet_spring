package com.example.bookshop.mapper;

import com.example.bookshop.dto.UserDto;
import com.example.bookshop.entity.User;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);
}
