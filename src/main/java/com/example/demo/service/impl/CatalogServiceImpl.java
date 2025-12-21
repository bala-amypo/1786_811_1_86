package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CropEntity;
import com.example.demo.entity.FertilizerEntity;
import com.example.demo.exception.AlreadyExistsException;
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
            throw new AlreadyExistsException("Crop already exists");
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
            throw new AlreadyExistsException("Fertilizer already exists");
        }

        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<FertilizerEntity> getAllFertilizers() {
        return fertilizerRepository.findAll();
    }
}
