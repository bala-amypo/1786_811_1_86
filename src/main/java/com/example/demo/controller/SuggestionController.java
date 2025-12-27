package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @GetMapping("/generate/{farmId}")
    public ResponseEntity<Suggestion> generate(@PathVariable Long farmId) {
        Suggestion suggestion = suggestionService.generateSuggestion(farmId);
        return ResponseEntity.ok(suggestion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suggestion> getSuggestion(@PathVariable long id) {
        Suggestion suggestion = suggestionService.getSuggestion(id);
        return ResponseEntity.ok(suggestion);
    }
}
