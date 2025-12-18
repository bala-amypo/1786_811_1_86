package com.example.demo.service.impl;

import com.example.demo.entity.FarmEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.FarmEntityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmEntityRepository farmRepository;
    private final UserRepository userRepository;

    @Override
    public FarmEntity createFarm(FarmEntity farm, Long ownerId) {
        UserEntity owner = userRepository.findById(ownerId).orElseThrow();
        farm.setOwner(owner);
        return farmRepository.save(farm);
    }

    @Override
    public List<FarmEntity> getFarmsByOwner(Long ownerId) {
        return farmRepository.findByOwnerId(ownerId);
    }

    @Override
    public FarmEntity getFarmById(Long farmId) {
        return farmRepository.findById(farmId).orElseThrow();
    }
}
