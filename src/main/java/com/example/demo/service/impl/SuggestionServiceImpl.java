package com.example.demo.service.impl;

import com.example.demo.entity.FarmEntity;
import com.example.demo.entity.SuggestionEntity;
import com.example.demo.repository.FarmEntityRepository;
import com.example.demo.repository.SuggestionEntityRepository;
import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmEntityRepository farmRepository;
    private final SuggestionEntityRepository suggestionRepository;

    @Override
    public SuggestionEntity generateSuggestion(Long farmId) {
        FarmEntity farm = farmRepository.findById(farmId).orElseThrow();

        SuggestionEntity suggestion = SuggestionEntity.builder()
                .farm(farm)
                .suggestedCrops("Rice,Wheat")
                .suggestedFertilizers("Urea,DAP")
                .build();

        return suggestionRepository.save(suggestion);
    }

    @Override
    public SuggestionEntity getSuggestion(Long suggestionId) {
        return suggestionRepository.findById(suggestionId).orElseThrow();
    }

    @Override
    public List<SuggestionEntity> getSuggestionsByFarm(Long farmId) {
        return suggestionRepository.findByFarmId(farmId);
    }
}
