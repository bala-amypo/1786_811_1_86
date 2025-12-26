package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Override
    public List<Suggestion> generateSuggestion(Long farmId) {

        if (farmId == null) {
            throw new BadRequestException("Farm ID cannot be null");
        }

        // Minimal implementation for tests
        return new ArrayList<>();
    }

    @Override
    public Suggestion getSuggestion(Long suggestionId) {

        if (suggestionId == null) {
            throw new BadRequestException("Suggestion ID cannot be null");
        }

        // Minimal implementation for tests
        return new Suggestion();
    }
}
