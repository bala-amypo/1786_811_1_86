package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.service.FarmService;
import com.example.demo.service.SuggestionService;

import java.util.List;
import java.util.stream.Collectors;

public class SuggestionServiceImpl implements SuggestionService {

    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository suggestionRepository;

    public SuggestionServiceImpl(FarmService farmService,
                                 CatalogService catalogService,
                                 SuggestionRepository suggestionRepository) {
        this.farmService = farmService;
        this.catalogService = catalogService;
        this.suggestionRepository = suggestionRepository;
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmService.getFarmById(farmId);

        List<Crop> crops = catalogService.findSuitableCrops(
                farm.getSoilPH(), farm.getWaterLevel(), farm.getSeason());

        List<String> cropNames = crops.stream()
                .map(Crop::getName)
                .toList();

        String cropsCsv = String.join(",", cropNames);
        String fertsCsv = catalogService.findFertilizersForCrops(cropNames)
                .stream().map(Fertilizer::getName)
                .collect(Collectors.joining(","));

        Suggestion s = Suggestion.builder()
                .farm(farm)
                .suggestedCrops(cropsCsv)
                .suggestedFertilizers(fertsCsv)
                .build();

        return suggestionRepository.save(s);
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
