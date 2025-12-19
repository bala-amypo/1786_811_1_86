package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "crops")
public class CropEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Double suitablePHMin;

    @Column(nullable = false)
    private Double suitablePHMax;

    @Column(nullable = false)
    private Double requiredWater;

    @Column(nullable = false)
    private String season;

    public CropEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Double getSuitablePHMin() {
        return suitablePHMin;
    }

    public void setSuitablePHMin(Double suitablePHMin) {
        this.suitablePHMin = suitablePHMin;
    }

    public Double getSuitablePHMax() {
        return suitablePHMax;
    }

    public void setSuitablePHMax(Double suitablePHMax) {
        this.suitablePHMax = suitablePHMax;
    }

    public Double getRequiredWater() {
        return requiredWater;
    }

    public void setRequiredWater(Double requiredWater) {
        this.requiredWater = requiredWater;
    }

    public String getSeason() {
        return season;
    }
    
    public void setSeason(String season) {
        this.season = season;
    }
}
