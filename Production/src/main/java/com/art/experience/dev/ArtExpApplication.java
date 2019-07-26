package com.art.experience.dev;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.art.experience.dev.data"})
@EnableAutoConfiguration
public class ArtExpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtExpApplication.class, args);
    }

}
