package com.example.demo.service;

import com.example.demo.entity.FarmEntity;

import java.util.List;

public interface FarmService {

    FarmEntity createFarm(FarmEntity farm, Long ownerId);

    List<FarmEntity> getFarmsByOwner(Long ownerId);

    FarmEntity getFarmById(Long farmId);
}
