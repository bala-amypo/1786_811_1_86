package com.example.demo.service;

import com.example.demo.entity.SuggestionEntity;

import java.util.List;

public interface SuggestionService {

    SuggestionEntity generateSuggestion(Long farmId);

    SuggestionEntity getSuggestion(Long suggestionId);

    List<SuggestionEntity> getSuggestionsByFarm(Long farmId);
}
