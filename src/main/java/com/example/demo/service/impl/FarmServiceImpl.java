package com.example.demo;

import com.example.demo.entity.Farm;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FarmService;

import java.util.List;

public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepo;
    private final UserRepository userRepo;

    public FarmServiceImpl(FarmRepository farmRepo,
                           UserRepository userRepo) {
        this.farmRepo = farmRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Farm createFarm(Farm farm, Long ownerId) {
        return farm;
    }

    @Override
    public Farm getFarmById(Long id) {
        return null;
    }

    @Override
    public List<Farm> getFarmsByOwner(Long ownerId) {
        return List.of();
    }
}
