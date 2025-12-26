package com.example.demo.entity;

public class Crop {

    private Long id;
    private String name;

    public Crop() {}

    public Long getId() { return id; }
    public String getName() { return name; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Crop c = new Crop();

        public Builder id(long id) {
            c.id = id;
            return this;
        }

        public Builder name(String name) {
            c.name = name;
            return this;
        }

        public Crop build() {
            return c;
        }
    }
}
