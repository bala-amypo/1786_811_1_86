package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserEntity;

public interface UserService {

    UserEntity create(UserEntity user);

    List<UserEntity> getAll();

    UserEntity getById(Long id);

    UserEntity update(Long id, UserEntity user);

    void delete(Long id);
}
