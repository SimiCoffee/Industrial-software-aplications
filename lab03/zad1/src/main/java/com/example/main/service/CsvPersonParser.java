package com.example.main.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.example.main.domain.Person;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CsvPersonParser {

	public Map<String, Person> parseCsv(String file) {
		Map<String, Person> personMap = new HashMap<>();

		try (CSVReader reader = new CSVReader(
				new InputStreamReader(new ClassPathResource(file).getInputStream()))) {
			List<String[]> rows = reader.readAll();
			// Pomijamy nagłówek (pierwszy wiersz)
			for (int i = 1; i < rows.size(); i++) {
				String[] row = rows.get(i);
				String id = row[0];
				String firstName = row[1];
				String lastName = row[2];
				String email = row[3];
				int yearOfBirth = Integer.parseInt(row[4]);

				Person person = new Person(id, firstName, lastName, email, yearOfBirth);
				personMap.put(id, person);
			}
		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}

		return personMap;
	}
}
