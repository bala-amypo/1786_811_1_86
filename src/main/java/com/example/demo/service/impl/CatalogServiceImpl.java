package com.example.demo.service.impl;

import com.example.demo.entity.Catalog;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CatalogRepository;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

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

    // =====================================================
    // FIXED IMPLEMENTATIONS (NO INVALID CONSTRUCTORS)
    // =====================================================

    @Override
    public List<Crop> findSuitableCrops(Double temperature,
                                        Double rainfall,
                                        String soilType) {

        return catalogRepository.findAll()
                .stream()
                .map(c -> {
                    Crop crop = new Crop();
                    crop.setName(c.getCrop());
                    return crop;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<Crop> crops) {

        List<String> cropNames = crops.stream()
                .map(Crop::getName)
                .collect(Collectors.toList());

        return catalogRepository.findAll()
                .stream()
                .filter(c -> cropNames.contains(c.getCrop()))
                .map(c -> {
                    Fertilizer f = new Fertilizer();
                    f.setName(c.getFertilizer());
                    return f;
                })
                .collect(Collectors.toList());
    }
}
