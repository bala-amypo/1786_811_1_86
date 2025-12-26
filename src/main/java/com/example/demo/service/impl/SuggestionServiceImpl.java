package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final CatalogService catalogService;

    public SuggestionServiceImpl(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Override
    public List<Crop> suggestCrops(Double temperature,
                                   Double rainfall,
                                   String soilType) {

        return catalogService.findSuitableCrops(
                temperature,
                rainfall,
                soilType
        );
    }

    @Override
    public List<Fertilizer> suggestFertilizers(List<Crop> crops) {
        return catalogService.findFertilizersForCrops(crops);
    }
}
