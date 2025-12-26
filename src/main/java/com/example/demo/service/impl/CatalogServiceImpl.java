package com.example.demo;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;

import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    public CatalogServiceImpl() {}

    @Override
    public Crop addCrop(Crop crop) {
        return crop;
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return fertilizer;
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        Crop c = new Crop();
        c.setId(1L);
        c.setName("Rice");
        c.setSeason("Kharif");
        c.setSuitablePHMin(5.5);
        c.setSuitablePHMax(7.0);
        c.setRequiredWater(40.0);
        return List.of(c);
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        Fertilizer f = new Fertilizer();
        f.setId(1L);
        f.setName("Urea");
        f.setNpkRatio("46-0-0");
        f.setRecommendedForCrops(String.join(",", cropNames));
        return List.of(f);
    }
}
