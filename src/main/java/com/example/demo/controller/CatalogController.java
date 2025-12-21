package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CropEntity;
import com.example.demo.entity.FertilizerEntity;
import com.example.demo.service.CatalogService;

@RestController
@RequestMapping("/api")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/crops")
    public ResponseEntity<CropEntity> addCrop(@RequestBody CropEntity crop) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(catalogService.addCrop(crop));
    }

    @GetMapping("/crops")
    public List<CropEntity> getAllCrops() {
        return catalogService.getAllCrops();
    }

    @PostMapping("/fertilizers")
    public ResponseEntity<FertilizerEntity> addFertilizer(
            @RequestBody FertilizerEntity fertilizer) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(catalogService.addFertilizer(fertilizer));
    }

    @GetMapping("/fertilizers")
    public List<FertilizerEntity> getAllFertilizers() {
        return catalogService.getAllFertilizers();
    }
}
