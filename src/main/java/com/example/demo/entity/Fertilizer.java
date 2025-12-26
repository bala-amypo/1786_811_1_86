package com.example.demo.entity;

public class Fertilizer {

    private Long id;
    private String name;

    public Fertilizer() {}

    public Long getId() { return id; }
    public String getName() { return name; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final Fertilizer f = new Fertilizer();

        public Builder id(long id) { f.id = id; return this; }
        public Builder name(String name) { f.name = name; return this; }

        public Fertilizer build() { return f; }
    }
}
