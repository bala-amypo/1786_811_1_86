package com.example.demo.entity;

public class Crop {

    private Long id;
    private String name;
    private Double suitablePHMin;
    private Double suitablePHMax;

    public Crop() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getSuitablePHMin() { return suitablePHMin; }
    public Double getSuitablePHMax() { return suitablePHMax; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSuitablePHMin(Double v) { this.suitablePHMin = v; }
    public void setSuitablePHMax(Double v) { this.suitablePHMax = v; }

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

        // 🔥 REQUIRED BY TESTS
        public Builder suitablePHMin(double v) {
            c.suitablePHMin = v;
            return this;
        }

        // 🔥 REQUIRED BY TESTS
        public Builder suitablePHMax(double v) {
            c.suitablePHMax = v;
            return this;
        }

        public Crop build() {
            return c;
        }
    }
}
