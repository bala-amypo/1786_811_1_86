package com.example.demo.dto;

import com.example.demo.entity.Fertilizer;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FertilizerRequest {
    private String name;
    private String npkRatio;
    private String recommendedForCrops; // comma-separated

    public Fertilizer toEntity() {
        return Fertilizer.builder()
                .name(this.name)
                .npkRatio(this.npkRatio)
                .recommendedForCrops(this.recommendedForCrops)
                .build();
    }
}
