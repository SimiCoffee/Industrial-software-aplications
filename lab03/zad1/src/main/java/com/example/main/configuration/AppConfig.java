package com.example.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Qualifier;
import com.example.main.domain.Person;

@Configuration
public class AppConfig {

	@Bean
	@Scope("prototype")
	public Person createMan() {
		System.out.println("Creating Man");
		return new Person("550e8400-e29b-41d4-a716-446655440005", "Jan", "Kowalski-Przysłowiowy",
				"jan@example.com", 1970);
	}

	@Bean
	@Scope("singleton")
	@Qualifier("manager")
	public Person createWoman() {
		System.out.println("Creating Woman");
		return new Person("550e8400-e29b-41d4-a716-446655440006", "Janina", "Kowalska-Przysłowiowa",
				"janina@example.com", 1980);
	}
}
