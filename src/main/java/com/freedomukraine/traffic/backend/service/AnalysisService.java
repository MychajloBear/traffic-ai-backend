package com.freedomukraine.traffic.backend.service;

import com.freedomukraine.traffic.backend.dto.AnalysisResponse;
import org.springframework.stereotype.Service;

@Service
public class AnalysisService {
    private static final org.slf4j.Logger log =
        org.slf4j.LoggerFactory.getLogger(AnalysisService.class);

    public AnalysisResponse analyze(String questionText) {

        log.info("Analyzing question, length={}", questionText.length());
        if (questionText == null || questionText.isBlank()) {
            log.warn("Question text is empty or missing.");
            return new AnalysisResponse("UNKNOWN", "Question text is empty or missing.", 0.0);
        }

        String normalized = questionText.toLowerCase();

        if (normalized.contains("red light")) {
            log.info("Question contains 'red light'.");
            return new AnalysisResponse("Stop", "A driver must stop at a red traffic light.", 0.95);
        }

        log.info("Question does not match any known patterns.");
        return new AnalysisResponse("Unknown", "Fallback logic. AI integration will be added later.", 0.20);
    }
}
