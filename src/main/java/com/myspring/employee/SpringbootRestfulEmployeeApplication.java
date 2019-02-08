package com.myspring.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class SpringbootRestfulEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulEmployeeApplication.class, args);
	}

}

