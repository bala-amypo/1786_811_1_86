package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fertilizers")
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String npkRatio;
    private String recommendedForCrops;

    public Fertilizer() {}

    // getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getNpkRatio() { return npkRatio; }
    public String getRecommendedForCrops() { return recommendedForCrops; }

    // setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setNpkRatio(String npkRatio) { this.npkRatio = npkRatio; }
    public void setRecommendedForCrops(String recommendedForCrops) {
        this.recommendedForCrops = recommendedForCrops;
    }
}
