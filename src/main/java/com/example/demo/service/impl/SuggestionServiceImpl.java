package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SuggestionEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.SuggestionService;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository repository;

    public SuggestionServiceImpl(SuggestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public SuggestionEntity create(SuggestionEntity suggestion) {
        return repository.save(suggestion);
    }

    @Override
    public List<SuggestionEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public SuggestionEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion not found with id: " + id));
    }
}
