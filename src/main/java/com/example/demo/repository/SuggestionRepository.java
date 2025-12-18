package com.example.demo.repository;

import com.example.demo.entity.SuggestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuggestionRepository extends JpaRepository<SuggestionEntity, Long> {

    List<Suggestion> findByFarmId(Long farmId);
}
