package com.example.demo.entity;

import java.util.List;

public class Suggestion {

    private List<String> suggestedCrops;
    private List<String> suggestedFertilizers;

    public List<String> getSuggestedCrops() { return suggestedCrops; }
    public List<String> getSuggestedFertilizers() { return suggestedFertilizers; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final Suggestion s = new Suggestion();

        public Builder suggestedCrops(String crop) {
            s.suggestedCrops = List.of(crop);
            return this;
        }

        public Builder suggestedFertilizers(String fertilizer) {
            s.suggestedFertilizers = List.of(fertilizer);
            return this;
        }

        public Suggestion build() { return s; }
    }
}
