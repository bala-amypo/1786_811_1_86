package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/suggestions")
@RequiredArgsConstructor
@Tag(name = "Suggestions")
public class SuggestionController {
    private final SuggestionService suggestionService;

    @Operation(summary = "Generate suggestion for a farm")
    @PostMapping("/{farmId}")
    public ResponseEntity<Suggestion> generate(@PathVariable Long farmId) {
        return ResponseEntity.ok(suggestionService.generateSuggestion(farmId));
    }

    @Operation(summary = "Get suggestion by id")
    @GetMapping("/{suggestionId}")
    public ResponseEntity<Suggestion> getSuggestion(@PathVariable Long suggestionId) {
        return ResponseEntity.ok(suggestionService.getSuggestion(suggestionId));
    }

    @Operation(summary = "List suggestions for a farm")
    @GetMapping("/farm/{farmId}")
    public ResponseEntity<List<Suggestion>> listByFarm(@PathVariable Long farmId) {
        return ResponseEntity.ok(suggestionService.getSuggestionsByFarm(farmId));
    }
}
