package com.example.demo.entity;

public class Fertilizer {

    private Long id;
    private String name;
    private String npkRatio;

    public Fertilizer() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getNpkRatio() { return npkRatio; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setNpkRatio(String npkRatio) { this.npkRatio = npkRatio; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Fertilizer f = new Fertilizer();

        public Builder id(long id) {
            f.id = id;
            return this;
        }

        public Builder name(String name) {
            f.name = name;
            return this;
        }

        public Builder npkRatio(String ratio) {
            f.npkRatio = ratio;
            return this;
        }

        public Fertilizer build() {
            return f;
        }
    }
}

