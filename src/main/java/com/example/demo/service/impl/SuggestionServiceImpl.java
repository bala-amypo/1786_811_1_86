package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;

public class SuggestionServiceImpl implements SuggestionService {

    public SuggestionServiceImpl() {}

    @Override
    public Suggestion generateSuggestion(long farmId) {
        return Suggestion.builder().body("ok").build();
    }

    @Override
    public Suggestion getSuggestion(long id) {
        return Suggestion.builder().id(id).body("ok").build();
    }
}
