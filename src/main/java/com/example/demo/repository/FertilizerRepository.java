package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FertilizerEntity;

public interface FertilizerRepository extends JpaRepository<FertilizerEntity, Long> {

    Optional<FertilizerEntity> findByName(String name);

    List<FertilizerEntity> findByRecommendedForCropsContaining(String cropName);
}
