package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CropEntity;
import com.example.demo.entity.FertilizerEntity;

public interface CatalogService {

    CropEntity addCrop(CropEntity crop);
    List<CropEntity> getAllCrops();

   
    FertilizerEntity addFertilizer(FertilizerEntity fertilizer);
    List<FertilizerEntity> getAllFertilizers();
}
