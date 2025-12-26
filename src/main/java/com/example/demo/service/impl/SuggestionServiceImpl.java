package com.example.demo;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;

import java.util.List;

/**
 * Required ONLY because tests directly instantiate this class.
 */
public class SuggestionServiceImpl implements SuggestionService {

    private final com.example.demo.service.impl.SuggestionServiceImpl delegate;

    public SuggestionServiceImpl() {
        this.delegate = new com.example.demo.service.impl.SuggestionServiceImpl();
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        return delegate.generateSuggestion(farmId);
    }

    @Override
    public Suggestion getSuggestion(Long id) {
        return delegate.getSuggestion(id);
    }

    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return delegate.getSuggestionsByFarm(farmId);
    }
}
