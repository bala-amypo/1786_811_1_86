package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;

public class SuggestionServiceImpl {

    public Suggestion getSuggestion(long id) {
        Suggestion s = Suggestion.builder()
                .id(id)
                .body("OK")
                .suggestedCrops("Rice")
                .build();
        s.prePersist();
        return s;
    }
}
