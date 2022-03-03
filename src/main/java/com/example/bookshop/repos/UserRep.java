package com.example.bookshop.repos;

import com.example.bookshop.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Long>{
    
    User findByUsername(String username);
}
