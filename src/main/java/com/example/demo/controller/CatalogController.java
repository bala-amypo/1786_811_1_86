package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CropEntity;
import com.example.demo.entity.FertilizerEntity;
import com.example.demo.service.CatalogService;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService service) {
        this.service = service;
    }

    // CROPS
    @PostMapping("/crops")
    public CropEntity addCrop(@RequestBody CropEntity crop) {
        return service.addCrop(crop);
    }

    @GetMapping("/crops")
    public List<CropEntity> getAllCrops() {
        return service.getAllCrops();
    }

    // FERTILIZERS
    @PostMapping("/fertilizers")
    public FertilizerEntity addFertilizer(@RequestBody FertilizerEntity fertilizer) {
        return service.addFertilizer(fertilizer);
    }

    @GetMapping("/fertilizers")
    public List<FertilizerEntity> getAllFertilizers() {
        return service.getAllFertilizers();
    }
}
