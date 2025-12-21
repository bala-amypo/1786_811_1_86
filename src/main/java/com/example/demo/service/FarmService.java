package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.FarmEntity;

public interface FarmService {

    FarmEntity create(FarmEntity farm);

    List<FarmEntity> getAll();

    FarmEntity getById(Long id);

}
