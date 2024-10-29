package com.example.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import com.example.main.service.PersonService;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class MainApplication {

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	CommandLineRunner run() {
		return args -> {
			personService.printAllMembers();
		};
	}
}
