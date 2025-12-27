package com.example.demo.dto;

import com.example.demo.entity.Crop;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CropRequest {
    private String name;
    private Double suitablePHMin;
    private Double suitablePHMax;
    private Double requiredWater;
    private String season;

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
