package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FertilizerEntity;

public interface FertilizerRepository extends JpaRepository<FertilizerEntity, Long> {

    List<FertilizerEntity> findByRecommendedForCropsContaining(String cropName);
}
