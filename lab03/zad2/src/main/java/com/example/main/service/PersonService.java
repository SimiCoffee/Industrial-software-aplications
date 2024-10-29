package com.example.main.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.main.domain.Person;

import java.util.List;

@Service
public class PersonService {

	private final Person prezes;
	private final Person wiceprezes;
	private final Person sekretarz;
	private final List<Person> remainingMembers;

	// `@Autowired` nie jest wymagane przy jednym konstruktorze
	public PersonService(@Qualifier("prezes") Person prezes,
			@Qualifier("wiceprezes") Person wiceprezes,
			@Qualifier("sekretarz") Person sekretarz,
			List<Person> remainingMembers) {
		this.prezes = prezes;
		this.wiceprezes = wiceprezes;
		this.sekretarz = sekretarz;
		this.remainingMembers = remainingMembers;
	}

	public void printAllMembers() {
		System.out.println("Prezes: " + prezes);
		System.out.println("Wiceprezes: " + wiceprezes);
		System.out.println("Sekretarz: " + sekretarz);
		remainingMembers.forEach(member -> System.out.println("Pozostały członek: " + member));
	}
}
