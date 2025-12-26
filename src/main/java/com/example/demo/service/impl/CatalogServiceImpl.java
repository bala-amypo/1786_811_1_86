package com.example.demo.service.impl;

import com.example.demo.entity.Catalog;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CatalogRepository;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    // ✅ Constructor used by Spring
    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    // ✅ Constructor used by unit tests (if needed)
    public CatalogServiceImpl() {
        this.catalogRepository = null;
    }

    @Override
    public Catalog save(Catalog catalog) {
        if (catalogRepository == null) {
            throw new BadRequestException("Repository not initialized");
        }
        return catalogRepository.save(catalog);
    }

    @Override
    public List<Catalog> findAll() {
        if (catalogRepository == null) {
            throw new BadRequestException("Repository not initialized");
        }
        return catalogRepository.findAll();
    }

    @Override
    public Catalog findById(long id) {
        if (catalogRepository == null) {
            throw new BadRequestException("Repository not initialized");
        }
        return catalogRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Catalog not found"));
    }
}
