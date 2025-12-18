package com.example.demo.repository;

import com.example.demo.entity.FertilizerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FertilizerRepository extends JpaRepository<FertilizerEntity, Long> {

    List<Fertilizer> findByRecommendedForCropsContaining(String cropName);
}
