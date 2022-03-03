package com.example.bookshop.service;

import java.util.Collections;

import com.example.bookshop.dto.UserDto;
import com.example.bookshop.entity.Role;
import com.example.bookshop.entity.User;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User findByUsername(UserDto userDto) {
        return userRepository.findByUsername(userDto.getUsername());
    }

    public void save(UserDto userDto) {
        User user = new User();
        
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));

        userRepository.save(user);
    }
}
