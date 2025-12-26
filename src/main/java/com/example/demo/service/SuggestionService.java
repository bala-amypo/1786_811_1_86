package com.example.demo.service;

import com.example.demo.entity.Suggestion;

public interface SuggestionService {

    // REQUIRED by tests & controller
    Suggestion generate(Long farmId);
}
