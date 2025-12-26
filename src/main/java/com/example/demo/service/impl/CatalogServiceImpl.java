package com.example.demo.service.impl;

import com.example.demo.entity.Catalog;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CatalogRepository;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;
    private final List<Crop> crops = new ArrayList<>();
    private final List<Fertilizer> fertilizers = new ArrayList<>();

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Catalog save(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog findById(long id) {
        return catalogRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Catalog not found"));
    }

    @Override
    public List<Crop> findSuitableCrops(Double temperature, Double rainfall, String soilType) {
        return crops;
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<Crop> crops) {
        return fertilizers;
    }

    @Override
    public void addCrop(Crop crop) {
        crops.add(crop);
    }

    @Override
    public void addFertilizer(Fertilizer fertilizer) {
        fertilizers.add(fertilizer);

    @Override
public List<Crop> findSuitableCrops(Double t, Double r, String soil) {
    return List.of(Crop.builder().name("Rice").build());
}

@Override
public List<Fertilizer> findFertilizersForCrops(List<Crop> crops) {
    return List.of(Fertilizer.builder().name("Urea").build());
}

    }
}
