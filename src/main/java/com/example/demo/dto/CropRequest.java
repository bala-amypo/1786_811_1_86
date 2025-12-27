package com.example.demo.dto;

import com.example.demo.entity.Crop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CropRequest {

    private String name;
    private double suitablePHMin;
    private double suitablePHMax;
    private double requiredWater;
    private String season;

    /**
     * Convert DTO to entity
     */
    public Crop toEntity() {
        return Crop.builder()
                .name(this.name)
                .suitablePHMin(this.suitablePHMin)
                .suitablePHMax(this.suitablePHMax)
                .requiredWater(this.requiredWater)
                .season(this.season)
                .build();
    }
}
