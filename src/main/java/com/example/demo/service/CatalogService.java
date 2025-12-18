package com.example.demo.service;

import com.example.demo.entity.CropEntity;
import com.example.demo.entity.FertilizerEntity;

import java.util.List;

public interface CatalogService {

    CropEntity addCrop(CropEntity crop);

    FertilizerEntity addFertilizer(FertilizerEntity fertilizer);

    List<CropEntity> findSuitableCrops(Double ph, Double waterLevel, String season);

    List<FertilizerEntity> findFertilizersForCrops(List<String> cropNames);
}
