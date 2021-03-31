package com.example.Microservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class Microservice2 {

	public static void main(String[] args) {
		SpringApplication.run(Microservice2.class, args);
	}

}
