package com.example.demo.service;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    // Original interface methods (entities)
    Crop addCrop(Crop crop);

    Fertilizer addFertilizer(Fertilizer f);

    List<Crop> findSuitableCrops(Double ph, Double water, String season);

    List<Fertilizer> findFertilizersForCrops(List<String> cropNames);

    // ✅ Optional: default methods for DTOs can be declared here (not required)
}
