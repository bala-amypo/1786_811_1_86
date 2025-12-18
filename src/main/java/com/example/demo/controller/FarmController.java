package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.FarmEntity;
import com.example.demo.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;

    @PostMapping("/{userId}")
    public Farm addFarm(@PathVariable Long userId,
                        @RequestBody FarmRequest request) {
        return farmService.addFarm(userId, request);
    }

    @GetMapping("/{userId}")
    public List<Farm> getFarms(@PathVariable Long userId) {
        return farmService.getFarmsByUser(userId);
    }
}
