package com.example.demo.entity;

public class Suggestion {

    private String body;
    private int statusCodeValue = 200;

    public Suggestion() {}

    public String getBody() {
        return body;
    }

    public int getStatusCodeValue() {
        return statusCodeValue;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
