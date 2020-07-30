package com.example.cacheh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Cacheh2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cacheh2Application.class, args);		
	}

}
