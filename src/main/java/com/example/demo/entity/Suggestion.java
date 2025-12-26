package com.example.demo.entity;

import java.time.LocalDateTime;

public class Suggestion {

    private Long id;
    private String body;
    private String suggestedCrops;
    private LocalDateTime createdAt;

    public Suggestion() {}

    public Long getId() { return id; }
    public String getBody() { return body; }
    public String getSuggestedCrops() { return suggestedCrops; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(long id) {
        this.id = id;
    }

    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

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

        public Builder body(String body) {
            s.body = body;
            return this;
        }

        public Builder suggestedCrops(String crops) {
            s.suggestedCrops = crops;
            return this;
        }

        public Builder farm(Object ignored) {
            return this;
        }

        public Suggestion build() {
            return s;
        }
    }
}
