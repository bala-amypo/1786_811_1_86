package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.FarmEntity;
import com.example.demo.service.FarmEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmEntityService farmService;

    // POST /farms → add farm
    @PostMapping
    public FarmEntity createFarm(@RequestBody FarmRequest req,
                                 Authentication auth) {
        return farmService.createFarm(req, auth);
    }

    // GET /farms → list user farms
    @GetMapping
    public List<FarmEntity> listFarms(Authentication auth) {
        return farmService.listFarms(auth);
    }

    // GET /farms/{farmId} → get farm details
    @GetMapping("/{farmId}")
    public FarmEntity getFarm(@PathVariable Long farmId) {
        return farmService.getFarm(farmId);
    }
}
