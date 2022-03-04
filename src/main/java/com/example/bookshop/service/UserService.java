package com.example.bookshop.service;

import com.example.bookshop.dto.UserDto;
import com.example.bookshop.entity.User;
import com.example.bookshop.mapper.UserMapper;
import com.example.bookshop.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User findByUsername(UserDto userDto) {
        return userRepository.findByUsername(userDto.getUsername());
    }

    public void save(UserDto userDto) {
        userRepository.save(userMapper.userDtoToUser(userDto));
    }
}
