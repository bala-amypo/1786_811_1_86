package com.example.demo.repository;

import com.example.demo.entity.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CropRepository extends JpaRepository<CropEntity, Long> {

    @Query("""
        SELECT c FROM CropEntity c
        WHERE c.suitablePHMin <= :ph
          AND c.suitablePHMax >= :ph
          AND c.requiredWater <= :water
          AND c.season = :season
    """)
    List<CropEntity> findSuitableCrops(
            @Param("ph") Double ph,
            @Param("water") Double water,
            @Param("season") String season
    );
}
