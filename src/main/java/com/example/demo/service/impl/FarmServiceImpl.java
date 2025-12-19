package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FarmEntity;

public interface FarmRepository extends JpaRepository<FarmEntity, Long> {

    List<FarmEntity> findByOwnerId(Long ownerId);
}
