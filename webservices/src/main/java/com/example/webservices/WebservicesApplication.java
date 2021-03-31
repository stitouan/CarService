package com.example.webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer

public class WebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebservicesApplication.class, args);
	}

}
