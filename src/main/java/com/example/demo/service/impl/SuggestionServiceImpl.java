package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    public SuggestionServiceImpl() {
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        return Suggestion.builder()
                .id(1L)
                .suggestedCrops("Rice")
                .suggestedFertilizers("Urea")
                .build();
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
