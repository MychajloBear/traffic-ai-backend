package com.freedomukraine.traffic.backend.dto;

public record AnalysisResponse(
        String answer,
        String explanation,
        double confidence
) {}
