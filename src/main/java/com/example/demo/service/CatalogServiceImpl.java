package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
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

    @Override
    public Crop addCrop(Crop crop) {
        return crop;
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer f) {
        return f;
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
