package com.example.bookshop.mapper;

import java.util.Collections;

import com.example.bookshop.dto.UserDto;
import com.example.bookshop.entity.Role;
import com.example.bookshop.entity.User;

public class UserMapperImpl implements UserMapper {
    @Override
    public UserDto userToUserDto(User user) {
        if(user == null)
            return null;
        
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    @Override
    public User userDtoToUser(UserDto userDto) {
        if(userDto == null)
            return null;
        
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);

        return user;
    }
}
