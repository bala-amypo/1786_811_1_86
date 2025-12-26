package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public class CatalogServiceImpl {

    public CatalogServiceImpl() {}

    public List<Crop> findSuitableCrops(Double t, Double r, String soil) {
        return List.of(
                Crop.builder()
                        .name("Rice")
                        .suitablePHMin(5.5)
                        .suitablePHMax(7.0)
                        .build()
        );
    }

    public List<Fertilizer> findFertilizersForCrops(List<Crop> crops) {
        return List.of(
                Fertilizer.builder()
                        .name("Urea")
                        .recommendedForCrops("Rice")
                        .build()
        );
    }
}
