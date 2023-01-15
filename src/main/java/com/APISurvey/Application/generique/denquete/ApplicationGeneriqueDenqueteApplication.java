package com.APISurvey.Application.generique.denquete;

import com.APISurvey.Application.generique.denquete.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ApplicationGeneriqueDenqueteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationGeneriqueDenqueteApplication.class, args);
	}

	/**
	 * @param args
	 * @throws Exception
	 */

	@Autowired
	RoleRepository roleRepository;
	@Override
	public void run(String... args) throws Exception {
		if (roleRepository.findAll().size() ==0){
			roleRepository.creerrole();
		}

	}
}
