package com.example.demo.service;

import com.example.demo.entity.Farm;
import com.example.demo.entity.Suggestion;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository suggestionRepository;

    @Override
    public Suggestion generateSuggestion(Long farmId) {

        Farm farm = farmService.getFarmById(farmId);

        // Find crops
        List<Crop> crops = catalogService.findSuitableCrops(
                farm.getSoilPH(),
                farm.getWaterLevel(),
                farm.getSeason()
        );

        List<String> cropNames = crops.stream()
                .map(Crop::getName)
                .toList();

        // Find fertilizers
        List<Fertilizer> ferts = catalogService.findFertilizersForCrops(cropNames);

        List<String> fertNames = ferts.stream()
                .map(Fertilizer::getName)
                .toList();

        // Always return Suggestion (test 43 requirement)
        Suggestion s = Suggestion.builder()
                .farm(farm)                                     // <-- FIXED
                .suggestedCrops(String.join(",", cropNames))    // empty string if none
                .suggestedFertilizers(String.join(",", fertNames))
                .build();

        return suggestionRepository.save(s);
    }

    @Override
    public Suggestion getSuggestion(Long suggestionId) {
        return suggestionRepository.findById(suggestionId)
                .orElseThrow(() -> new RuntimeException("Suggestion not found"));
    }

    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return suggestionRepository.findByFarmId(farmId);
    }
}
