package com.example.main.domain;

public class Person {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private int yearOfBirth;

	public Person(String id, String firstName, String lastName, String email, int yearOfBirth) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.yearOfBirth = yearOfBirth;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", yearOfBirth=" + yearOfBirth +
				'}';
	}
}
