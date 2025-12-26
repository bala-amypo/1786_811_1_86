package com.example.demo.controller;

import com.example.demo.entity.Catalog;
import com.example.demo.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
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
