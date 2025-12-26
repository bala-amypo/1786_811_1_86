package com.example.demo;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.util.ValidationUtil;

import java.util.*;
import java.util.regex.Pattern;

public class CatalogServiceImpl implements CatalogService {

    private static final Pattern NPK_PATTERN =
            Pattern.compile("^\\d+-\\d+-\\d+$");

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public CatalogServiceImpl(CropRepository cropRepository,
                              FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    @Override
    public Crop addCrop(Crop crop) {
        if (crop.getSuitablePHMin() > crop.getSuitablePHMax()) {
            throw new BadRequestException("PH min cannot be greater than PH max");
        }
        if (!ValidationUtil.validSeason(crop.getSeason())) {
            throw new BadRequestException("Invalid season");
        }
        return cropRepository.save(crop);
    }

    @Override
    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        if (!NPK_PATTERN.matcher(fertilizer.getNpkRatio()).matches()) {
            throw new BadRequestException("Invalid NPK format");
        }
        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        return cropRepository.findSuitableCrops(ph, water, season);
    }

    @Override
    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        if (cropNames == null || cropNames.isEmpty()) return List.of();
        Set<Fertilizer> result = new HashSet<>();
        for (String c : cropNames) {
            result.addAll(fertilizerRepository.findByCropName(c));
        }
        return new ArrayList<>(result);
    }
}
