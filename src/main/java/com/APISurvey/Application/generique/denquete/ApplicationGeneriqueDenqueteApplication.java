package com.APISurvey.Application.generique.denquete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ApplicationGeneriqueDenqueteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationGeneriqueDenqueteApplication.class, args);
	}

}
