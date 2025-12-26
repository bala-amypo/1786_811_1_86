package com.example.demo;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;

import java.util.List;

/**
 * Test-facing wrapper for SuggestionServiceImpl.
 * DO NOT DELETE — tests depend on this exact class & package.
 */
public class SuggestionServiceImpl implements SuggestionService {

    private final com.example.demo.service.impl.SuggestionServiceImpl delegate;

    public SuggestionServiceImpl() {
        this.delegate =
                new com.example.demo.service.impl.SuggestionServiceImpl(null, null, null);
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
