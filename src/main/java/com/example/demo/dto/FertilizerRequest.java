package com.example.demo.dto;

public class FertilizerRequest {
    private String name;
    private String npkRatio;
    private String recommendedForCrops;

    public FertilizerRequest() {}

    public FertilizerRequest(String name, String npk, String crops) {
        this.name = name;
        this.npkRatio = npk;
        this.recommendedForCrops = crops;
    }

    public String getName() { return name; }
    public String getNpkRatio() { return npkRatio; }
    public String getRecommendedForCrops() { return recommendedForCrops; }
}
