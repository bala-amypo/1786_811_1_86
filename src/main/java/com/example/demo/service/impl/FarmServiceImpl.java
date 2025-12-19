package com.example.demo.service.impl;

import com.example.demo.entity.FarmEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FarmRepository;
import com.example.demo.service.FarmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository repository;

    public FarmServiceImpl(FarmRepository repository) {
        this.repository = repository;
    }

    @Override
    public FarmEntity create(FarmEntity farm) {
        return repository.save(farm);
    }

    @Override
    public List<FarmEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public FarmEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found with id: " + id));
    }

    @Override
    public FarmEntity update(Long id, FarmEntity farm) {
        FarmEntity existing = getById(id);
        existing.setName(farm.getName());
        existing.setSoilPH(farm.getSoilPH());
        existing.setWaterLevel(farm.getWaterLevel());
        existing.setSeason(farm.getSeason());
        existing.setOwner(farm.getOwner());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
