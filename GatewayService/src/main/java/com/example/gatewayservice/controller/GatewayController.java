package com.example.gatewayservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;

@RestController
public class GatewayController {

    @GetMapping("/fallback/patients")
    public ResponseEntity<String> fallbackPatients() {
        return ResponseEntity.ok("Le service des patients est temporairement indisponible. Veuillez réessayer plus tard.");
    }

    @GetMapping("/praticiens")
    public ResponseEntity<String> fallbackPraticiens() {
        return ResponseEntity.ok("Le service des praticiens est temporairement indisponible. Veuillez réessayer plus tard.");
    }
    
}
