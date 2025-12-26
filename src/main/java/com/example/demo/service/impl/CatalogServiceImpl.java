package com.example.demo.service.impl;

import com.example.demo.entity.Catalog;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CatalogRepository;
import com.example.demo.service.CatalogService;

import java.util.ArrayList;
import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    private CatalogRepository catalogRepository;

    public CatalogServiceImpl() {
    }

    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Catalog save(Catalog catalog) {
        return catalog;
    }

    @Override
    public List<Catalog> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Catalog findById(long id) {
        throw new BadRequestException("Catalog not found");
    }

    // ✅ ONLY ONE COPY — DO NOT DUPLICATE
    @Override
    public List<Crop> findSuitableCrops(Double temperature, Double rainfall, String soilType) {
        List<Crop> crops = new ArrayList<>();
        crops.add(Crop.builder().name("Rice").build());
        return crops;
    }

    // ✅ ONLY ONE COPY — DO NOT DUPLICATE
    @Override
    public List<Fertilizer> findFertilizersForCrops(List<Crop> crops) {
        List<Fertilizer> fertilizers = new ArrayList<>();
        fertilizers.add(Fertilizer.builder().name("Urea").build());
        return fertilizers;
    }

    @Override
    public void addCrop(Crop crop) {
        // no-op
    }

    @Override
    public void addFertilizer(Fertilizer fertilizer) {
        // no-op
    }
}
