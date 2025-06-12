package com.trailone.journalApp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1")
public class HealthCheck {
    /**
     * @return
     */
    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
