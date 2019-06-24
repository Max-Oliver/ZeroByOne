package com.art.experience.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RestController
public class MainAplication {
		public static void main(String[] args) throws Exception {
			SpringApplication.run(MainAplication.class, args);
		}
	}


