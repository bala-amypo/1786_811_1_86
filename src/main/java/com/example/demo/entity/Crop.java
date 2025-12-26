package com.example.demo.entity;

public class Crop {

    private String name;

    public Crop() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 🔹 Builder required by tests
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Crop crop = new Crop();

        public Builder name(String name) {
            crop.setName(name);
            return this;
        }

        public Crop build() {
            return crop;
        }
    }
}
