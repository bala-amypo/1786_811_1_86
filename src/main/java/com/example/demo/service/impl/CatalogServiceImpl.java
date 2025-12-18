package com.example.demo.service.impl;

import com.example.demo.entity.CropEntity;
import com.example.demo.entity.FertilizerEntity;
import com.example.demo.repository.CropEntityRepository;
import com.example.demo.repository.FertilizerEntityRepository;
import com.example.demo.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CropEntityRepository cropRepository;
    private final FertilizerEntityRepository fertilizerRepository;

    @Override
    public CropEntity addCrop(CropEntity crop) {
        return cropRepository.save(crop);
    }

    @Override
    public FertilizerEntity addFertilizer(FertilizerEntity fertilizer) {
        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<CropEntity> findSuitableCrops(Double ph, Double waterLevel, String season) {
        return cropRepository.findSuitableCrops(ph, waterLevel, season);
    }

    @Override
    public List<FertilizerEntity> findFertilizersForCrops(List<String> cropNames) {
        return fertilizerRepository.findByCropNames(cropNames);
    }
}
