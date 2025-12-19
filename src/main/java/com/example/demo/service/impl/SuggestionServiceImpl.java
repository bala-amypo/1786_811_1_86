package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SuggestionEntity;

public interface SuggestionRepository extends JpaRepository<SuggestionEntity, Long> {

    List<SuggestionEntity> findByFarmId(Long farmId);
}
