package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/crop")
    public ResponseEntity<Crop> addCrop(@RequestBody Crop crop, Authentication auth) {
        Crop saved = catalogService.addCrop(crop);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/fertilizer")
    public ResponseEntity<Fertilizer> addFertilizer(@RequestBody Fertilizer fertilizer, Authentication auth) {
        Fertilizer saved = catalogService.addFertilizer(fertilizer);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/find-crops")
    public ResponseEntity<List<Crop>> findCrops(@RequestParam Double temp,
                                                @RequestParam Double rain,
                                                @RequestParam String soil) {
        List<Crop> crops = catalogService.findSuitableCrops(temp, rain, soil);
        return ResponseEntity.ok(crops);
    }

    @GetMapping("/find-ferts")
    public ResponseEntity<List<Fertilizer>> findFerts(@RequestParam String crop) {
        List<Fertilizer> ferts = catalogService.findFertilizersForCrops(List.of(crop));
        return ResponseEntity.ok(ferts);
    }
}
