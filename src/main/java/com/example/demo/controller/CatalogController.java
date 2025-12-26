package com.example.demo.controller;

import com.example.demo.entity.Catalog;
import com.example.demo.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

    private final CatalogService catalogService;

    // Constructor injection
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping
    public Catalog createCatalog(@RequestBody Catalog catalog) {
        return catalogService.save(catalog);
    }

    @GetMapping
    public List<Catalog> getAllCatalogs() {
        return catalogService.findAll();
    }

    @GetMapping("/{id}")
    public Catalog getCatalogById(@PathVariable long id) {
        return catalogService.findById(id);
    }
}
