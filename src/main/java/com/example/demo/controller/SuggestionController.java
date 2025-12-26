package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @GetMapping("/generate/{farmId}")
    public Suggestion generate(@PathVariable Long farmId) {
        // ✅ FIX: call the correct method name
        return suggestionService.generateSuggestion(farmId);
    }

    @GetMapping("/{id}")
    public Suggestion getSuggestion(@PathVariable long id) {
        return suggestionService.getSuggestion(id);
    }
}
