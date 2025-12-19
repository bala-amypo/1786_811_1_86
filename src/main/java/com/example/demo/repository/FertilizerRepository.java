package com.example.demo.repository;

import com.example.demo.entity.FertilizerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FertilizerRepository extends JpaRepository<FertilizerEntity, Long> {

    @Query("""
        SELECT f FROM FertilizerEntity f
        WHERE f.recommendedForCrops LIKE %:cropName%
    """)
    List<FertilizerEntity> findFertilizersByRecommendedCrops(
            @Param("cropName") String cropName
    );
}
