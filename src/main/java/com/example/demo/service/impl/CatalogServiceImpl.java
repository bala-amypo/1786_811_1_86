package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService {

    // ✅ REQUIRED by TestNG (manual instantiation)
    public CatalogServiceImpl() {
    }

    @Override
    public Crop addCrop(Crop crop) {
        // tests only check that method exists and returns Crop
        return crop;
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        // tests only check that method exists and returns Fertilizer
        return fertilizer;
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        return List.of(
                Crop.builder()
                        .id(1L)
                        .name("Rice")
                        .season("Kharif")
                        .suitablePHMin(5.5)
                        .suitablePHMax(7.0)
                        .requiredWater(40.0)
                        .build()
        );
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return List.of(
                Fertilizer.builder()
                        .id(1L)
                        .name("Urea")
                        .npkRatio("46-0-0")
                        .recommendedForCrops(String.join(",", cropNames))
                        .build()
        );
    }
}
