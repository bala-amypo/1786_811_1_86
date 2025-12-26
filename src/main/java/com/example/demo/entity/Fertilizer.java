package com.example.demo.entity;

import java.util.List;

public class Fertilizer {

    private String name;
    private String npkRatio;
    private List<String> recommendedForCrops;

    public Fertilizer() {}

    public String getName() {
        return name;
    }

    public String getNpkRatio() {
        return npkRatio;
    }

    public List<String> getRecommendedForCrops() {
        return recommendedForCrops;
    }

    // 🔹 Builder required by tests
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Fertilizer f = new Fertilizer();

        public Builder name(String name) {
            f.name = name;
            return this;
        }

        public Builder npkRatio(String npk) {
            f.npkRatio = npk;
            return this;
        }

        public Builder recommendedForCrops(List<String> crops) {
            f.recommendedForCrops = crops;
            return this;
        }

        public Fertilizer build() {
            return f;
        }
    }
}
