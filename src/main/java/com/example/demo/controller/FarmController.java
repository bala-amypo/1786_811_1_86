package com.example.demo.controller;

import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping("/{ownerId}")
    public Farm createFarm(@PathVariable Long ownerId,
                           @RequestBody Farm farm) {
        return farmService.createFarm(farm, ownerId);
    }

    @GetMapping("/{id}")
    public Farm getFarm(@PathVariable Long id) {
        return farmService.getFarmById(id);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Farm> getFarmsByOwner(@PathVariable Long ownerId) {
        return farmService.getFarmsByOwner(ownerId);
    }
}
