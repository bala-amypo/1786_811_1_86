package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FarmEntity;
import com.example.demo.service.FarmService;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService service;

    public FarmController(FarmService service) {
        this.service = service;
    }

    @PostMapping
    public FarmEntity create(@RequestBody FarmEntity farm) {
        return service.create(farm);
    }

    @GetMapping
    public List<FarmEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public FarmEntity getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
