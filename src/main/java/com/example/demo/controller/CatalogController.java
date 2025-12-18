package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.CropEntity;
import com.example.demo.entity.FertilizerEntity;
import com.example.demo.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    // ADMIN
    @PostMapping("/crop")
    public CropEntity addCrop(@RequestBody CropRequest req,
                              Authentication auth) {
        return catalogService.addCrop(req, auth);
    }

    // ADMIN
    @PostMapping("/fertilizer")
    public FertilizerEntity addFertilizer(@RequestBody FertilizerRequest req,
                                          Authentication auth) {
        return catalogService.addFertilizer(req, auth);
    }

    // GET suitable crops
    @GetMapping("/crops/suitable")
    public List<CropEntity> getSuitableCrops(@RequestParam Double ph,
                                             @RequestParam Double water,
                                             @RequestParam String season) {
        return catalogService.getSuitableCrops(ph, water, season);
    }

    // GET fertilizers by crop
    @GetMapping("/fertilizers/by-crop")
    public List<FertilizerEntity> getFertilizersByCrop(@RequestParam String name) {
        return catalogService.getFertilizersByCrop(name);
    }
}
