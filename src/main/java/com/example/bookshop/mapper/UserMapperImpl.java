package com.example.bookshop.mapper;

import com.example.bookshop.dto.UserDto;
import com.example.bookshop.entity.Role;
import com.example.bookshop.entity.User;

import java.util.Collections;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {
    public final PasswordEncoder passwordEncoder;

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));

        return user;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setPassword( user.getPassword() );
        userDto.setUsername( user.getUsername() );

        return userDto;
    }
}
