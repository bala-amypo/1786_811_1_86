package com.example.demo.entity;

public class Suggestion {

    private Long id;
    private String body;

    public Suggestion() {}

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
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

        public Suggestion build() {
            return s;
        }
    }
}

