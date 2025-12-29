package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
@Tag(name = "Crop & Fertilizer Catalog")
public class CatalogController {
    private final CatalogService catalogService;

    @Operation(summary = "Add crop (ADMIN only)")
    @PostMapping("/crop")
    public ResponseEntity<Crop> addCrop(@RequestBody CropRequest req, Authentication auth) {
    
        var roles = auth.getAuthorities();
        boolean isAdmin = roles.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin) return ResponseEntity.status(403).build();

        Crop c = Crop.builder()
                .name(req.getName())
                .suitablePHMin(req.getSuitablePHMin())
                .suitablePHMax(req.getSuitablePHMax())
                .requiredWater(req.getRequiredWater())
                .season(req.getSeason())
                .build();
        return ResponseEntity.ok(catalogService.addCrop(c));
    }

    @Operation(summary = "Add fertilizer (ADMIN only)")
    @PostMapping("/fertilizer")
    public ResponseEntity<Fertilizer> addFertilizer(@RequestBody FertilizerRequest req, Authentication auth) {
        var roles = auth.getAuthorities();
        boolean isAdmin = roles.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin) return ResponseEntity.status(403).build();

        Fertilizer f = Fertilizer.builder()
                .name(req.getName())
                .npkRatio(req.getNpkRatio())
                .recommendedForCrops(req.getRecommendedForCrops())
                .build();
        return ResponseEntity.ok(catalogService.addFertilizer(f));
    }

    @Operation(summary = "Find suitable crops by ph, water and season")
    @GetMapping("/crops/suitable")
    public ResponseEntity<List<Crop>> findCrops(@RequestParam Double ph, @RequestParam Double water, @RequestParam String season) {
        return ResponseEntity.ok(catalogService.findSuitableCrops(ph, water, season));
    }

    @Operation(summary = "Find fertilizers by crop name")
    @GetMapping("/fertilizers/by-crop")
    public ResponseEntity<List<Fertilizer>> findFerts(@RequestParam String name) {
        return ResponseEntity.ok(catalogService.findFertilizersForCrops(List.of(name)));
    }
}
