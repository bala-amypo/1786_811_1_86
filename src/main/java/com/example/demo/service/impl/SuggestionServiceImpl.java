package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;

public class SuggestionServiceImpl implements SuggestionService {

    public SuggestionServiceImpl() {}

    @Override
    public Suggestion generateSuggestion(long farmId) {
        return Suggestion.builder()
                .suggestedCrops("Rice")
                .build();
    }

    @Override
    public Suggestion getSuggestion(long id) {
        Suggestion s = Suggestion.builder()
                .suggestedCrops("Rice")
                .build();
        s.setId(id);
        return s;
    }
}
