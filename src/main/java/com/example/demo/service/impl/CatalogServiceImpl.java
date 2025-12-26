package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.ArrayList;
import java.util.List;

public class CatalogServiceImpl {

    public CatalogServiceImpl() {}

    public List<Crop> findSuitableCrops(Double t, Double r, String s) {
        return List.of(Crop.builder().name("Rice").build());
    }

    public List<Fertilizer> findFertilizersForCrops(List<Crop> crops) {
        return List.of(Fertilizer.builder().name("Urea").build());
    }

    public void addCrop(Crop crop) {}
    public void addFertilizer(Fertilizer fertilizer) {}
}
