package dummy;

import java.util.Scanner;

enum Planet {
	MERCURY(0.2408467),
	VENUS(0.61519726),
	EARTH(1),
	MARS(1.8808158),
	JUPITER(11.862615),
	SATURN(29.447498),
	URANUS(84.016846),
	NEPTUNE(164.79132);

	private final double value;

	Planet(double value) {
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}
}

public class Seconds {

	public static void menu() {
		System.out.println("wybierz planetę");
		System.out.println("1. Merkury");
		System.out.println("2. Wenus");
		System.out.println("3. Earth");
		System.out.println("4. Mars");
		System.out.println("5. Jupiter");
		System.out.println("6. Saturn");
		System.out.println("7. Uranus");
		System.out.println("8. Neptune");

	}

	public static double calculateAge(Planet planet, int seconds) {
		double earthYear = 31557600;
		double age = seconds / earthYear;
		return age /= planet.getValue();
	}

	public static double calculateAgeInput(Scanner reader) {
		menu();
		int planetChoice = reader.nextInt();
		reader.nextLine();
		System.out.println("Podaj wiek w sekundach: ");
		int seconds = reader.nextInt();
		reader.nextLine();
		Planet planet = Planet.values()[planetChoice - 1];
		double age = calculateAge(planet, seconds);
		return age;
	}
}
