package com.example.demo.entity;

public class Crop {

    private Long id;
    private String name;
    private Double suitablePHMin;

    public Crop() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getSuitablePHMin() { return suitablePHMin; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSuitablePHMin(Double v) { this.suitablePHMin = v; }

    // ===== BUILDER =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Crop c = new Crop();

        public Builder id(long id) {
            c.setId(id);
            return this;
        }

        public Builder name(String name) {
            c.setName(name);
            return this;
        }

        public Builder suitablePHMin(double v) {
            c.setSuitablePHMin(v);
            return this;
        }

        public Crop build() {
            return c;
        }
    }
}
