package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
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
    public void addCrop(@RequestBody Crop crop, Authentication auth) {
        catalogService.addCrop(crop);
    }

    @PostMapping("/fertilizer")
    public void addFertilizer(@RequestBody Fertilizer fertilizer, Authentication auth) {
        catalogService.addFertilizer(fertilizer);
    }

    @GetMapping("/find-crops")
    public List<Crop> findCrops(@RequestParam Double temp,
                                @RequestParam Double rain,
                                @RequestParam String soil) {
        return catalogService.findSuitableCrops(temp, rain, soil);
    }

    @GetMapping("/find-ferts")
    public List<Fertilizer> findFerts(@RequestParam String crop) {
        // ✅ service expects List<String>, NOT List<Crop>
        return catalogService.findFertilizersForCrops(List.of(crop));
    }
}
