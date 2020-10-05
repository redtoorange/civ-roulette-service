package com.andrewmcguiness.civroulette.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping
    private ResponseEntity<String> getHealth() {
        return ResponseEntity.ok("Service it running");
    }
}
