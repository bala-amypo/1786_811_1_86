package com.example.demo.entity;

public class Crop {

    private Long id;
    private String name;
    private Double minTemp;
    private Double maxTemp;
    private Double minRainfall;
    private String soilType;

    public Crop() {
    }

    public Crop(Long id, String name, Double minTemp, Double maxTemp, Double minRainfall, String soilType) {
        this.id = id;
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.minRainfall = minRainfall;
        this.soilType = soilType;
    }

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
}
