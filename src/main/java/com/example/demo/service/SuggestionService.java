package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.SuggestionEntity;

public interface SuggestionService {

    SuggestionEntity create(SuggestionEntity suggestion);

    List<SuggestionEntity> getAll();

    SuggestionEntity getById(Long id);


}
