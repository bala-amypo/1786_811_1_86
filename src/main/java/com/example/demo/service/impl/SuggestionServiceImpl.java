package com.example.demo;

public class SuggestionServiceImpl
        extends com.example.demo.service.impl.SuggestionServiceImpl {

    public SuggestionServiceImpl(
            com.example.demo.service.FarmService farmService,
            com.example.demo.service.CatalogService catalogService,
            com.example.demo.repository.SuggestionRepository suggestionRepository
    ) {
        super(farmService, catalogService, suggestionRepository);
    }
}
