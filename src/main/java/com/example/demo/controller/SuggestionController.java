package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SuggestionEntity;
import com.example.demo.service.SuggestionService;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionService service;

    public SuggestionController(SuggestionService service) {
        this.service = service;
    }

    @PostMapping
    public SuggestionEntity create(@RequestBody SuggestionEntity suggestion) {
        return service.create(suggestion);
    }

    @GetMapping
    public List<SuggestionEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SuggestionEntity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Suggestion deleted successfully";
    }
}
