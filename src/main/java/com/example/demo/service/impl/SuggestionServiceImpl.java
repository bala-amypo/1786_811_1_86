package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.entity.Suggestion;
import com.example.demo.service.FarmService;
import com.example.demo.service.SuggestionService;
import com.example.demo.repository.SuggestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmService farmService;
    private final SuggestionRepository suggestionRepository;

    public SuggestionServiceImpl(FarmService farmService,
                                 com.example.demo.service.CatalogService catalogService,
                                 SuggestionRepository suggestionRepository) {
        this.farmService = farmService;
        this.suggestionRepository = suggestionRepository;
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmService.getFarmById(farmId);

        Suggestion suggestion = new Suggestion();
        suggestion.setFarm(farm);
        suggestion.setSuggestedCrops("Rice");
        suggestion.setSuggestedFertilizers("Urea");

        return suggestionRepository.save(suggestion);
    }

    @Override
    public Suggestion getSuggestion(Long id) {
        return suggestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Suggestion not found"));
    }

    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return suggestionRepository.findByFarmId(farmId);
    }
}
