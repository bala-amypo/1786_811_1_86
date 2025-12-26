package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;

public class SuggestionServiceImpl {

    public Suggestion getSuggestion(long id) {
      Suggestion suggestion = new Suggestion();
suggestion.setFarm(farm);
suggestion.setSuggestedCrops(cropsCsv);
suggestion.setSuggestedFertilizers(fertsCsv);

return suggestionRepository.save(suggestion);

        return suggestion;
    }
}
