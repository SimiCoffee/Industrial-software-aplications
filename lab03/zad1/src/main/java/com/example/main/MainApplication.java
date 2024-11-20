package com.example.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import com.example.main.domain.Person;
import com.example.main.service.CsvPersonParser;

import java.util.Map;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ApplicationContext ctx, CsvPersonParser csvPersonParser) {
		return args -> {
			String fileName = "people.csv";
			Map<String, Person> personMap = csvPersonParser.parseCsv(fileName);

			// Wypisujemy wszystkie osoby
			personMap.values().forEach(System.out::println);

			// Pobieramy beany z kontekstu
			Person man = (Person) ctx.getBean("createMan");
			Person woman = (Person) ctx.getBean("createWoman");

			System.out.println("Created Person beans:");
			System.out.println(man);
			System.out.println(woman);
		};
	}
}
