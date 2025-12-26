package com.example.demo.service;

import com.example.demo.entity.Catalog;

import java.util.List;

public interface CatalogService {

    Catalog save(Catalog catalog);

    List<Catalog> findAll();

    Catalog findById(long id);

    // 🔹 REQUIRED BY SuggestionService
    List<String> findSuitableCrops(Double temperature, Double rainfall, String soilType);

    // 🔹 REQUIRED BY SuggestionService
    List<String> findFertilizersForCrops(List<String> crops);
}
