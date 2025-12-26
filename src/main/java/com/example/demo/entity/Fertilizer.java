package com.example.demo.entity;

public class Fertilizer {

    private Long id;
    private String name;

    public Fertilizer() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // ✅ THIS WAS MISSING
    public void setName(String name) {
        this.name = name;
    }
}
