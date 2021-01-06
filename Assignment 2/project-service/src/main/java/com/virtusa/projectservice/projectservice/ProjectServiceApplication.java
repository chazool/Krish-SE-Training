package com.virtusa.projectservice.projectservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProjectServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjectServiceApplication.class, args);
	}
}
