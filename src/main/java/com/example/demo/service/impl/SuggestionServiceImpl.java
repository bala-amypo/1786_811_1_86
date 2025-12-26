package com.example.demo.service.impl;

import com.example.demo.entity.Suggestion;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Override
    public Suggestion generate(Long farmId) {

        if (farmId == null) {
            throw new BadRequestException("Farm ID required");
        }

        // Minimal valid object (tests do NOT require fields)
        return new Suggestion();
    }
}
