package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fertilizer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(nullable = false)
    private String name;

  
    @Column(name = "npk_ratio")
    private String npkRatio;

    // Test expects a single string, NOT List<String>
    @Column(name = "recommended_for_crops")
    private String recommendedForCrops;

    // Required for repository findByCropName()
    @Column(name = "crop_name")
    private String cropName;

    private String description;
    private Double nutrientN;
    private Double nutrientP;
    private Double nutrientK;
}
