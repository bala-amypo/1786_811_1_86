package com.example.demo.util;

import java.util.ArrayList;

public class BodyList<T> extends ArrayList<T> {

    public String getBody() {
        return this.toString();
    }
}
