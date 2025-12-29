package com.example.demo.service;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    @Override
    public Crop addCrop(Crop crop) {
        if (crop.getSuitablePHMin() > crop.getSuitablePHMax()) {
            throw new BadRequestException("PH min cannot be greater than PH max");
        }
       
        if (!List.of("Kharif","Rabi","Summer").contains(crop.getSeason())) {
            throw new BadRequestException("Invalid season");
        }
        return cropRepository.save(crop);
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        
        if (!fertilizer.getNpkRatio().matches("\\d+-\\d+-\\d+")) {
            throw new BadRequestException("Invalid NPK format, expected N-P-K");
        }
        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double waterLevel, String season) {
       
        List<Crop> byPHAndSeason = cropRepository.findSuitableCrops(ph, season);
       
        return byPHAndSeason.stream()
                .filter(c -> c.getRequiredWater() == null || c.getRequiredWater() <= waterLevel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        Set<Fertilizer> result = new HashSet<>();
        for (String cropName : cropNames) {
            List<Fertilizer> found = fertilizerRepository.findByCropName(cropName.toLowerCase());
            result.addAll(found);
        }
        return new ArrayList<>(result);
    }
}
