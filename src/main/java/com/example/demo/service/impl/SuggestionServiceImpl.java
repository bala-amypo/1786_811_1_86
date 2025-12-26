package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.service.*;

public class SuggestionServiceImpl implements SuggestionService {

    public SuggestionServiceImpl() {}

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        return new Suggestion();
    }

    @Override
    public Suggestion getSuggestion(Long id) {
        return new Suggestion();
    }
}
