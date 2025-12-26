package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;

public class SuggestionServiceImpl implements SuggestionService {

    @Override
    public Suggestion generate(Long farmId) {
        Suggestion s = new Suggestion();
        s.setBody("Generated for farm " + farmId);
        return s;
    }

    @Override
    public Suggestion getSuggestion(long id) {
        Suggestion s = new Suggestion();
        s.setBody("Suggestion " + id);
        return s;
    }
}
