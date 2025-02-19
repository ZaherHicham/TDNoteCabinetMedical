/*package com.example.gatewayservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;

@RestController
public class GatewayController {

    @Autowired
    RestTemplate restTemplate;

    public GatewayController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String PATIENT_SERVICE_URL = "http://patient-service/patients";
    private static final String PRATICIEN_SERVICE_URL = "http://praticien-service/praticiens";

    // ------------------ SERVICE PATIENT ------------------

    @GetMapping("/patients")
    @CircuitBreaker(name = "patientService", fallbackMethod = "patientFallback")
    public ResponseEntity<String> getAllPatients() {
        return restTemplate.exchange("http://localhost:8080/patients", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {});
    }

    @GetMapping("/patients/{id}")
    @CircuitBreaker(name = "patientService", fallbackMethod = "patientFallback")
    public ResponseEntity<String> getPatientById(@PathVariable int id) {
        return restTemplate.exchange(PATIENT_SERVICE_URL + "/" + id, HttpMethod.GET, null, String.class);
    }

    @PostMapping("/patients/post")
    @CircuitBreaker(name = "patientService", fallbackMethod = "patientFallback")
    public ResponseEntity<String> createPatient(@RequestBody String patient) {
        HttpEntity<String> request = new HttpEntity<>(patient);
        return restTemplate.exchange(PATIENT_SERVICE_URL, HttpMethod.POST, request, String.class);
    }

    @PutMapping("/patients/{id}")
    @CircuitBreaker(name = "patientService", fallbackMethod = "patientFallback")
    public ResponseEntity<String> updatePatient(@PathVariable int id, @RequestBody String patient) {
        HttpEntity<String> request = new HttpEntity<>(patient);
        return restTemplate.exchange(PATIENT_SERVICE_URL + "/" + id, HttpMethod.PUT, request, String.class);
    }

    @DeleteMapping("/patients/{id}")
    @CircuitBreaker(name = "patientService", fallbackMethod = "patientFallback")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
        return restTemplate.exchange(PATIENT_SERVICE_URL + "/" + id, HttpMethod.DELETE, null, String.class);
    }

    // ------------------ SERVICE PRATICIEN ------------------

    @GetMapping("/praticiens")
    @CircuitBreaker(name = "praticienService", fallbackMethod = "praticienFallback")
    public ResponseEntity<String> getAllPraticiens() {
        return restTemplate.exchange(PRATICIEN_SERVICE_URL, HttpMethod.GET, null, String.class);
    }

    @GetMapping("/praticiens/{id}")
    @CircuitBreaker(name = "praticienService", fallbackMethod = "praticienFallback")
    public ResponseEntity<String> getPraticienById(@PathVariable int id) {
        return restTemplate.exchange(PRATICIEN_SERVICE_URL + "/" + id, HttpMethod.GET, null, String.class);
    }

    @PostMapping("/praticiens")
    @CircuitBreaker(name = "praticienService", fallbackMethod = "praticienFallback")
    public ResponseEntity<String> createPraticien(@RequestBody String praticien) {
        HttpEntity<String> request = new HttpEntity<>(praticien);
        return restTemplate.exchange(PRATICIEN_SERVICE_URL, HttpMethod.POST, request, String.class);
    }

    @PutMapping("/praticiens/{id}")
    @CircuitBreaker(name = "praticienService", fallbackMethod = "praticienFallback")
    public ResponseEntity<String> updatePraticien(@PathVariable int id, @RequestBody String praticien) {
        HttpEntity<String> request = new HttpEntity<>(praticien);
        return restTemplate.exchange(PRATICIEN_SERVICE_URL + "/" + id, HttpMethod.PUT, request, String.class);
    }

    @DeleteMapping("/praticiens/{id}")
    @CircuitBreaker(name = "praticienService", fallbackMethod = "praticienFallback")
    public ResponseEntity<String> deletePraticien(@PathVariable int id) {
        return restTemplate.exchange(PRATICIEN_SERVICE_URL + "/" + id, HttpMethod.DELETE, null, String.class);
    }

    // ------------------ FALLBACK METHODS ------------------

    public ResponseEntity<String> patientFallback(Exception e) {
        return ResponseEntity.ok("Le service des patients est temporairement indisponible. Veuillez réessayer plus tard.");
    }

    public ResponseEntity<String> praticienFallback(Exception e) {
        return ResponseEntity.ok("Le service des praticiens est temporairement indisponible. Veuillez réessayer plus tard.");
    }
}
*/