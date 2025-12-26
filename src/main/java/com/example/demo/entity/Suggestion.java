package com.example.demo.entity;

import java.time.Instant;
import java.util.List;

public class Suggestion {

    private Long id;
    private String body;
    private Instant createdAt;
    private List<Crop> suggestedCrops;

    public Suggestion() {}

    public Long getId() { return id; }
    public String getBody() { return body; }
    public Instant getCreatedAt() { return createdAt; }
    public List<Crop> getSuggestedCrops() { return suggestedCrops; }

    public void setId(Long id) { this.id = id; }
    public void setBody(String body) { this.body = body; }
    public void setSuggestedCrops(List<Crop> c) { this.suggestedCrops = c; }

    // called by tests
    public void prePersist() {
        this.createdAt = Instant.now();
    }

    // ===== BUILDER =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Suggestion s = new Suggestion();

        public Builder id(long id) {
            s.setId(id);
            return this;
        }

        public Builder body(String body) {
            s.setBody(body);
            return this;
        }

        public Builder suggestedCrops(List<Crop> crops) {
            s.setSuggestedCrops(crops);
            return this;
        }

        public Suggestion build() {
            return s;
        }
    }
}
