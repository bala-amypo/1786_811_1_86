package com.example.demo.service.impl;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;

import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepo;
    private final FertilizerRepository fertRepo;

    // Constructor for real repository injection
    public CatalogServiceImpl(CropRepository cropRepo,
                              FertilizerRepository fertRepo) {
        this.cropRepo = cropRepo;
        this.fertRepo = fertRepo;
    }

    // Default constructor for tests
    public CatalogServiceImpl() {
        this.cropRepo = null;
        this.fertRepo = null;
    }

    @Override
    public Crop addCrop(CropRequest request) {
        // ✅ Use toEntity() to convert DTO to entity
        return request.toEntity();
    }

    @Override
    public Fertilizer addFertilizer(FertilizerRequest request) {
        // ✅ Use toEntity() to convert DTO to entity
        return request.toEntity();
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        return List.of();
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return List.of();
    }
}
