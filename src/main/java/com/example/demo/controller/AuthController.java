package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // REGISTER USER
    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user) {
        return userService.create(user);
    }

    // LOGIN USER (basic demo)
    @PostMapping("/login")
    public String login(@RequestBody UserEntity user) {
        return "Login successful for user: " + user.getEmail();
    }
}
