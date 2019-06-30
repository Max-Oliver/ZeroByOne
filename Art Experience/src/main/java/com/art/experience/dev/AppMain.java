package com.art.experience.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableConfigurationProperties
@SpringBootApplication( exclude ={DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.art.experience.dev"})
//@EntityScan("com.art.experience.dev.model.Usuarios")
//@EnableJpaRepositories("com.art.experience.dev.data.UserRepositoryJpa")
public class AppMain {
	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}
}

