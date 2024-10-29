package com.example.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.main.domain.Person;

@Configuration
public class AppConfig {

	@Bean
	public Person prezes() {
		return new Person("550e8400-e29b-41d4-a716-446655440020", "Jan", "Kowalski", "jan.kowalski@example.com",
				1970);
	}

	@Bean
	public Person wiceprezes() {
		return new Person("550e8400-e29b-41d4-a716-446655440021", "Anna", "Nowak", "anna.nowak@example.com",
				1980);
	}

	@Bean
	public Person sekretarz() {
		return new Person("550e8400-e29b-41d4-a716-446655440022", "Marek", "Wiśniewski",
				"marek.wisniewski@example.com", 1992);
	}
}
