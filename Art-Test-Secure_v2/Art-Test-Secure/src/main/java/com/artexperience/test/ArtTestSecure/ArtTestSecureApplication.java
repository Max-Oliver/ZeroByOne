package com.artexperience.test.ArtTestSecure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigServer
@ComponentScan(basePackages = "com.artexperience.test.ArtTestSecure.data")
public class ArtTestSecureApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtTestSecureApplication.class, args);
	}

}
