package com.example.demo;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;

import java.util.List;

/**
 * Test-facing wrapper for CatalogServiceImpl.
 * DO NOT DELETE — tests depend on this exact class & package.
 */
public class CatalogServiceImpl implements CatalogService {

    private final com.example.demo.service.impl.CatalogServiceImpl delegate;

    public CatalogServiceImpl() {
        this.delegate = new com.example.demo.service.impl.CatalogServiceImpl();
    }

    @Override
    public Crop addCrop(Crop crop) {
        return delegate.addCrop(crop);
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return delegate.addFertilizer(fertilizer);
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        return delegate.findSuitableCrops(ph, water, season);
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return delegate.findFertilizersForCrops(cropNames);
    }
}
