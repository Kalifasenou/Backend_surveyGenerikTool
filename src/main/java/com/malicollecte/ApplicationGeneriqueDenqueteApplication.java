package com.malicollecte;

import com.malicollecte.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationGeneriqueDenqueteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationGeneriqueDenqueteApplication.class, args);
	}


	@Autowired
	RoleRepository roleRepository;
	@Override
	public void run(String... args) throws Exception {
		if (roleRepository.findAll().size() ==0){
			roleRepository.creerrole();
		}

	}
}
