package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CropEntity;

public interface CropRepository extends JpaRepository<CropEntity, Long> {
}
