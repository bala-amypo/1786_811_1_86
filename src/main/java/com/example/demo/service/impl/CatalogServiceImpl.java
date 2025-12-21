package com.example.demo.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.CropEntity;
import com.example.demo.entity.FertilizerEntity;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public CatalogServiceImpl(CropRepository cropRepository,
                              FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    @Override
    public CropEntity addCrop(CropEntity crop) {

        if (cropRepository.findByName(crop.getName()).isPresent()) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Crop already exists with name: " + crop.getName()
            );
        }

        return cropRepository.save(crop);
    }

    @Override
    public List<CropEntity> getAllCrops() {
        return cropRepository.findAll();
    }

    @Override
    public FertilizerEntity addFertilizer(FertilizerEntity fertilizer) {

        if (fertilizerRepository.findByName(fertilizer.getName()).isPresent()) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Fertilizer already exists with name: " + fertilizer.getName()
            );
        }

        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<FertilizerEntity> getAllFertilizers() {
        return fertilizerRepository.findAll();
    }
}
