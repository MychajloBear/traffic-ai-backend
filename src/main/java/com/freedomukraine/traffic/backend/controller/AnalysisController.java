package com.freedomukraine.traffic.backend.controller;

import com.freedomukraine.traffic.backend.dto.AnalysisRequest;
import com.freedomukraine.traffic.backend.dto.AnalysisResponse;
import com.freedomukraine.traffic.backend.service.AnalysisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    private final AnalysisService service;

    public AnalysisController(AnalysisService service) {
        this.service = service;
    }

    @PostMapping
    public AnalysisResponse analyze(@RequestBody AnalysisRequest request) {
        return service.analyze(request.questionText());
    }
}
