package com.example.demo;

public class CatalogServiceImpl
        extends com.example.demo.service.impl.CatalogServiceImpl {

    public CatalogServiceImpl(
            com.example.demo.repository.CropRepository cropRepository,
            com.example.demo.repository.FertilizerRepository fertilizerRepository
    ) {
        super(cropRepository, fertilizerRepository);
    }
}
