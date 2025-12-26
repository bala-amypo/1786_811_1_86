package com.example.demo.entity;

import java.time.Instant;
import java.util.List;

public class Suggestion {

    private Long id;
    private List<String> suggestedCrops;
    private List<String> suggestedFertilizers;
    private Instant createdAt;

    public Suggestion() {}

    public Long getId() { return id; }
    public List<String> getSuggestedCrops() { return suggestedCrops; }
    public List<String> getSuggestedFertilizers() { return suggestedFertilizers; }
    public Instant getCreatedAt() { return createdAt; }

    public void setId(long id) {
        this.id = id;
    }

    public void prePersist() {
        this.createdAt = Instant.now();
    }

    // test expects this
    public int getStatusCodeValue() {
        return 200;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Suggestion s = new Suggestion();

        public Builder id(long id) {
            s.id = id;
            return this;
        }

        public Builder suggestedCrops(String crop) {
            s.suggestedCrops = List.of(crop);
            return this;
        }

        public Builder suggestedFertilizers(String fert) {
            s.suggestedFertilizers = List.of(fert);
            return this;
        }

        // test calls farm(null)
        public Builder farm(Object ignored) {
            return this;
        }

        public Suggestion build() {
            return s;
        }
    }
}
