package com.example.demo.controller;

import com.example.demo.entity.Catalog;
import com.example.demo.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import org.springframework.security.core.Authentication;


import java.util.List;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

@PostMapping("/crop")
public void addCrop(@RequestBody CropRequest req, Authentication auth) {
    Crop crop = new Crop();
    crop.setName(req.getName());
    catalogService.addCrop(crop);
}

@PostMapping("/fertilizer")
public void addFertilizer(@RequestBody FertilizerRequest req, Authentication auth) {
    Fertilizer f = new Fertilizer();
    f.setName(req.getName());
    catalogService.addFertilizer(f);
}

@GetMapping("/find-crops")
public List<Crop> findCrops(double temp, double rain, String soil) {
    return catalogService.findSuitableCrops(temp, rain, soil);
}

@GetMapping("/find-ferts")
public List<Fertilizer> findFerts(String crop) {
    Crop c = new Crop();
    c.setName(crop);
    return catalogService.findFertilizersForCrops(List.of(c));
}


    @PostMapping
    public Catalog create(@RequestBody Catalog catalog) {
        return catalogService.save(catalog);
    }

    @GetMapping
    public List<Catalog> getAll() {
        return catalogService.findAll();
    }

    @GetMapping("/{id}")
    public Catalog getById(@PathVariable long id) {
        return catalogService.findById(id);
    }
}
