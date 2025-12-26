package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.entity.User;
import com.example.demo.service.FarmService;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;
    private final UserService userService;

    // ✅ Constructor EXACTLY as tests expect
    public FarmController(FarmService farmService,
                          UserService userService) {
        this.farmService = farmService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Farm> createFarm(@RequestBody FarmRequest request,
                                           Authentication auth) {

        User user = userService.findByEmail(auth.getName());

        Farm farm = Farm.builder()
                .name(request.getName())
                .soilPH(request.getSoilPH())
                .waterLevel(request.getWaterLevel())
                .season(request.getSeason())
                .owner(user)
                .build();

        return ResponseEntity.ok(
                farmService.createFarm(farm, user.getId())
        );
    }

    @GetMapping
    public ResponseEntity<List<Farm>> listFarms(Authentication auth) {
        User user = userService.findByEmail(auth.getName());
        return ResponseEntity.ok(
                farmService.getFarmsByOwner(user.getId())
        );
    }
}
