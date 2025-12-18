package com.example.demo.service;

import com.example.demo.entity.UserEntity;

public interface UserService {

    UserEntity register(UserEntity user);

    UserEntity findByEmail(String email);

    UserEntity findById(Long id);
}
