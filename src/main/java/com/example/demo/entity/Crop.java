package com.example.demo.entity;

public class Crop {

    private Long id;
    private String name;
    private String season;

    public Crop() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSeason() { return season; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final Crop c = new Crop();

        public Builder id(long id) { c.id = id; return this; }
        public Builder name(String name) { c.name = name; return this; }
        public Builder season(String season) { c.season = season; return this; }

        public Crop build() { return c; }
    }
}
