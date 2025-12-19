package com.example.demo.repository;

import com.example.demo.entity.FarmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FarmRepository extends JpaRepository<FarmEntity, Long> {

    List<FarmEntity> findByOwnerId(Long ownerId);

    Optional<FarmEntity> findByIdAndOwnerId(Long farmId, Long ownerId);
}
