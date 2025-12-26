package com.example.demo.service;

import com.example.demo.entity.Catalog;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface CatalogService {

    Catalog save(Catalog catalog);

    List<Catalog> findAll();

    Catalog findById(long id);

    List<Crop> findSuitableCrops(Double temperature, Double rainfall, String soilType);

    List<Fertilizer> findFertilizersForCrops(List<Crop> crops);

    void addCrop(Crop crop);

    void addFertilizer(Fertilizer fertilizer);
}
