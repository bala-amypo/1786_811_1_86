package com.example.demo;

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

    public CatalogServiceImpl(CropRepository cropRepo,
                              FertilizerRepository fertRepo) {
        this.cropRepo = cropRepo;
        this.fertRepo = fertRepo;
    }

    public CatalogServiceImpl() {
        this.cropRepo = null;
        this.fertRepo = null;
    }

    // Original entity-based method
    @Override
    public Crop addCrop(Crop crop) {
        // Normally you would save to repo:
        // return cropRepo.save(crop);
        return crop;
    }

    // New overload to accept CropRequest DTO
    public Crop addCrop(CropRequest request) {
        return addCrop(request.toEntity());
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer f) {
        // Normally: return fertRepo.save(f);
        return f;
    }

    // New overload to accept FertilizerRequest DTO
    public Fertilizer addFertilizer(FertilizerRequest request) {
        return addFertilizer(request.toEntity());
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
