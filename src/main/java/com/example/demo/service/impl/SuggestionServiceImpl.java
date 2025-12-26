package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;

public class SuggestionServiceImpl {

    public SuggestionServiceImpl() {}

    public Suggestion getSuggestion(long id) {
        return Suggestion.builder()
                .id(id)
                .suggestedCrops("Rice")
                .suggestedFertilizers("Urea")
                .build();
    }
}
