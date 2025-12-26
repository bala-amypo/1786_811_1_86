package com.example.demo.dto;

public class AuthResponseDto {

    private String token;

    // Required for Spring / Jackson
    public AuthResponseDto() {
    }

    // Required by your controller / tests
    public AuthResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
