package com.example.demo.service.impl;

import com.example.demo.entity.Catalog;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.CatalogService;

import java.util.ArrayList;
import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    public CatalogServiceImpl() {}

    @Override
    public Catalog save(Catalog catalog) {
        return catalog;
    }

    @Override
    public List<Catalog> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Catalog findById(long id) {
        throw new BadRequestException("Catalog not found");
    }

    @Override
    public List<Crop> findSuitableCrops(Double temperature, Double rainfall, String soilType) {
        List<Crop> crops = new ArrayList<>();
        Crop c = new Crop();
        c.setName("Rice");
        crops.add(c);
        return crops;
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<Crop> crops) {
        List<Fertilizer> list = new ArrayList<>();
        Fertilizer f = new Fertilizer();
        f.setName("Urea");
        list.add(f);
        return list;
    }

    @Override
    public void addCrop(Crop crop) {}

    @Override
    public void addFertilizer(Fertilizer fertilizer) {}
}
