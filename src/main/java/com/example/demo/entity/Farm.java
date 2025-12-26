package com.example.demo.entity;

public class Farm {

    private Long id;
    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;
    private User owner;

    public Farm() {}

    public String getName() { return name; }
    public Double getSoilPH() { return soilPH; }
    public Double getWaterLevel() { return waterLevel; }
    public String getSeason() { return season; }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Farm f = new Farm();

        public Builder name(String name) { f.name = name; return this; }
        public Builder soilPH(Double soilPH) { f.soilPH = soilPH; return this; }
        public Builder waterLevel(Double waterLevel) { f.waterLevel = waterLevel; return this; }
        public Builder season(String season) { f.season = season; return this; }

        public Farm build() { return f; }
    }
}
