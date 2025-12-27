package com.example.demo.dto;

import com.example.demo.entity.Fertilizer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FertilizerRequest {

    private String name;
    private String npkRatio;
    private String recommendedForCrops;

    /**
     * Convert DTO to entity
     */
    public Fertilizer toEntity() {
        return Fertilizer.builder()
                .name(this.name)
                .npkRatio(this.npkRatio)
                .recommendedForCrops(this.recommendedForCrops)
                .build();
    }
}
