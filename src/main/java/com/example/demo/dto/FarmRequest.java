package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmRequest {
    @NotBlank
    private String name;

    @NotNull
    private Double soilPH;

    @NotNull
    private Double waterLevel;

    @NotBlank
    private String season;


    public String getName() { return name; }
public Double getSoilPH() { return soilPH; }
public Double getWaterLevel() { return waterLevel; }
public String getSeason() { return season; }

}
