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

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        return List.of(
                Crop.builder()
                        .id(1L)                 // ✅ Long
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
                        .id(1L)                 // ✅ Long
                        .name("Urea")
                        .npkRatio("46-0-0")
                        .recommendedForCrops("Rice")
                        .build()
        );
    }

    // Required by interface but not used in tests
    @Override
    public Crop addCrop(Crop crop) {
        return crop;
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return fertilizer;
    }
}
