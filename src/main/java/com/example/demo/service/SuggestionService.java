package com.example.demo.service;

import com.example.demo.entity.Suggestion;

public interface SuggestionService {

    Suggestion generateSuggestion(long farmId);

    Suggestion getSuggestion(long id);
}
