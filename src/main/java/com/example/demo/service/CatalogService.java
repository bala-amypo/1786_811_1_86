package com.example.demo.service;

import com.example.demo.entity.Catalog;
import java.util.List;

public interface CatalogService {

    Catalog save(Catalog catalog);

    List<Catalog> findAll();

    Catalog findById(long id);
}
