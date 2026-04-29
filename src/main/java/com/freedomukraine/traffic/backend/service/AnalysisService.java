package com.freedomukraine.traffic.backend.service;

import com.freedomukraine.traffic.backend.dto.AnalysisResponse;
import org.springframework.stereotype.Service;

@Service
public class AnalysisService {

    public AnalysisResponse analyze(String questionText) {
        if (questionText == null || questionText.isBlank()) {
            return new AnalysisResponse("UNKNOWN", "Question text is empty or missing.", 0.0);
        }

        String normalized = questionText.toLowerCase();

        if (normalized.contains("red light")) {
            return new AnalysisResponse("Stop", "A driver must stop at a red traffic light.", 0.95);
        }

        return new AnalysisResponse("Unknown", "Fallback logic. AI integration will be added later.", 0.20);
    }
}
