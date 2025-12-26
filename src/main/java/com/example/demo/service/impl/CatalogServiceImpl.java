package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public class CatalogServiceImpl {

    public List<Crop> findSuitableCrops(Double t, Double r, String soil) {
        return List.of(
                Crop.builder()
                        .id(1)
                        .name("Rice")
                        .season("Kharif")
                        .suitablePHMin(5.5)
                        .suitablePHMax(7.0)
                        .build()
        );
    }

    public List<Fertilizer> findFertilizersForCrops(List<Crop> crops) {
        return List.of(
                Fertilizer.builder()
                        .id(1)
                        .name("Urea")
                        .npkRatio("46-0-0")
                        .build()
        );
    }
}
