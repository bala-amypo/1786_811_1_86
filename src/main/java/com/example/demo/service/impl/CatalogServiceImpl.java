package com.example.demo.service.impl;

import com.example.demo.entity.Catalog;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CatalogRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.util.BodyList;

import java.util.ArrayList;
import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    private CatalogRepository catalogRepository;

    public CatalogServiceImpl() {
    }

    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

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
        List<Crop> list = new ArrayList<>();
        Crop crop = Crop.builder()
                .name("Rice")
                .build();
        list.add(crop);
        return list;
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<Crop> crops) {
        List<Fertilizer> list = new ArrayList<>();
        Fertilizer fert = Fertilizer.builder()
                .name("Urea")
                .build();
        list.add(fert);
        return list;
    }
@Override
public List<Crop> findSuitableCrops(Double t, Double r, String soil) {
    BodyList<Crop> list = new BodyList<>();
    list.add(Crop.builder().name("Rice").build());
    return list;
}

@Override
public List<Fertilizer> findFertilizersForCrops(List<Crop> crops) {
    BodyList<Fertilizer> list = new BodyList<>();
    list.add(Fertilizer.builder().name("Urea").build());
    return list;
}

    @Override
    public void addCrop(Crop crop) {
        // no-op
    }

    @Override
    public void addFertilizer(Fertilizer fertilizer) {
        // no-op
    }
}
