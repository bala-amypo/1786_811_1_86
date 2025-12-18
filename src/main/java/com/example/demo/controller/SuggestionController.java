package com.example.demo.controller;

import com.example.demo.entity.SuggestionEntity;
import com.example.demo.service.SuggestionEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggestions")
@RequiredArgsConstructor
public class SuggestionController {

    private final SuggestionEntityService suggestionService;

    @PostMapping("/{farmId}")
    public SuggestionEntity generateSuggestion(@PathVariable Long farmId) {
        return suggestionService.generateSuggestion(farmId);
    }

    @GetMapping("/{suggestionId}")
    public SuggestionEntity getSuggestion(@PathVariable Long suggestionId) {
        return suggestionService.getSuggestion(suggestionId);
    }

    // GET /suggestions/farm/{farmId}
    @GetMapping("/farm/{farmId}")
    public List<SuggestionEntity> getSuggestionsByFarm(@PathVariable Long farmId) {
        return suggestionService.getSuggestionsByFarm(farmId);
    }
}
