package com.example.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	/*@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}*/

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("patient-service", r -> r.path("/patients/**")
						.filters(f -> f
								.rewritePath("/patients/(?<segment>.*)", "/patients/${segment}") // Redirection correcte
								.circuitBreaker(c -> c
										.setName("patientCircuitBreaker")
										.setFallbackUri("forward:/fallback/patients")) // Gestion de la résilience
						)
						.uri("lb://patient-service")) // Redirige vers le microservice patient

				.route("praticien-service", r -> r.path("/praticiens/**")
						.filters(f -> f
								.rewritePath("/praticiens/(?<segment>.*)", "/praticiens/${segment}") // Redirection correcte
								.circuitBreaker(c -> c
										.setName("praticienCircuitBreaker")
										.setFallbackUri("forward:/fallback/praticiens")) // Gestion de la résilience
						)
						.uri("lb://praticien-service")) // Redirige vers le microservice praticien

				.build();
	}

}
