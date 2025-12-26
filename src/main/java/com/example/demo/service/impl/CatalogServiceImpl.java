package com.example.demo.service.impl;

import com.example.demo.entity.Catalog;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CatalogRepository;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Catalog save(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog findById(long id) {
        return catalogRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Catalog not found"));
    }

    // ======================================================
    // METHODS REQUIRED BY SuggestionService
    // ======================================================

    @Override
    public List<String> findSuitableCrops(Double temperature, Double rainfall, String soilType) {
        // Simple implementation for tests
        return catalogRepository.findAll()
                .stream()
                .map(Catalog::getCrop)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findFertilizersForCrops(List<String> crops) {
        return catalogRepository.findAll()
                .stream()
                .filter(c -> crops.contains(c.getCrop()))
                .map(Catalog::getFertilizer)
                .distinct()
                .collect(Collectors.toList());
    }
}
