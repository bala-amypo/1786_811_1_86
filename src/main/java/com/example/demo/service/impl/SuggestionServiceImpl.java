package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;

import java.util.List;

public class SuggestionServiceImpl implements SuggestionService {

    public SuggestionServiceImpl() {}

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Suggestion s = new Suggestion();
        s.setId(1L);
        s.setSuggestedCrops("Rice");
        s.setSuggestedFertilizers("Urea");
        return s;
    }

    @Override
    public Suggestion getSuggestion(Long id) {
        return generateSuggestion(id);
    }

    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return List.of(generateSuggestion(farmId));
    }
}
