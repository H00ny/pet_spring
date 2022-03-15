package com.example.bookshop.service;

import java.util.List;
import java.util.Optional;

import com.example.bookshop.dto.UserDto;
import com.example.bookshop.entity.User;
import com.example.bookshop.mapper.UserMapper;
import com.example.bookshop.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  public final PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username);
  }

  public List<User> findAll() {
    List<User> users = userRepository.findAll();
    users.forEach(user -> user.setPassword(""));

    return users;
  }

  public void saveUser(UserDto userDto) {
    userRepository.save(userMapper.userDtoToUser(userDto));
  }

  public Optional<UserDto> findByUsername(String userName) {
    return Optional.ofNullable(userRepository.findByUsername(userName))
        .map(userMapper::userToUserDto);
  }
}
