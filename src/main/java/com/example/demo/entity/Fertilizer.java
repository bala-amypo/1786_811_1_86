package com.example.demo.entity;

public class Fertilizer {

    private Long id;
    private String name;
    private String type;
    private String description;

    public Fertilizer() {
    }

    public Fertilizer(Long id, String name, String type, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
