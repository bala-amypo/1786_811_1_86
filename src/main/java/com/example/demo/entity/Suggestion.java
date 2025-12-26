package com.example.demo.entity;

import java.time.Instant;
import java.util.List;

public class Suggestion {

    private Long id;
    private List<String> suggestedCrops;
    private Instant createdAt;

    public Suggestion() {}

    public Long getId() { return id; }
    public void setId(long id) { this.id = id; }

    // 🔥 REQUIRED BY TESTS
    public List<String> getSuggestedCrops() {
        return suggestedCrops;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Suggestion s = new Suggestion();

        // 🔥 REQUIRED BY TESTS
        public Builder suggestedCrops(String crop) {
            s.suggestedCrops = List.of(crop);
            return this;
        }

        public Builder suggestedCrops(List<String> crops) {
            s.suggestedCrops = crops;
            return this;
        }

        public Suggestion build() {
            s.createdAt = Instant.now();
            return s;
        }
    }
}
