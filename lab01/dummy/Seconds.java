package dummy;

import java.util.Scanner;

public class Seconds {
	// Jeżeli podamy wiek w sekundach, to jest możliwość obliczenia ile osoba ta ma
	// lat na ziemi.
	// Kula ziemska przechodzi przez własną orbitę przez 365,25 dnia, które wynosi
	// równo 31557600 sekund.
	// A więc jeżeli osoba ma 1000000000 sekund to łatwo można policzyć, że
	// 1000000000/31557600 = 31,69 lat (w przybliżeniu do drugiego miejsca po
	// przecinku).
	// Teraz rozpatrzmy metodę, która będzie przyjmowała wiek w sekundach oraz
	// planetę którą chcemy obliczyć.
	// Napisz program, który będzie zawierał tę metodę uwzględniając poniższe dane
	// dotyczące innych planet:
	//
	// Obrót Merkurego podczas własnej orbity wynosi 0.2408467 lat ziemskich
	// Obrót Wenus podczas własnej orbity wynosi 0.61519726 lat ziemskich
	// Obrót Marsa podczas własnej orbity wynosi 1.8808158 lat ziemskich
	// Obrót Jowisza podczas własnej orbity wynosi 11.862615 lat ziemskich
	// Obrót Saturna podczas własnej orbity wynosi 29.447498 lat ziemskich
	// Obrót Uranu podczas własnej orbity wynosi 84.016846 lat ziemskich
	// Obrót Neptuna podczas własnej orbity wynosi 164.79132 lat ziemskich

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

	public static double calculateAge(Scanner reader) {
		menu();
		int planet = reader.nextInt();
		reader.nextLine();
		System.out.println("Podaj wiek w sekundach: ");
		int seconds = reader.nextInt();
		reader.nextLine();
		double earthYear = 31557600;
		double age = seconds / earthYear;

		switch (planet) {
			case 1 -> age /= 0.2408467;
			case 2 -> age /= 0.61519726;
			case 3 -> age /= 1;
			case 4 -> age /= 1.8808158;
			case 5 -> age /= 11.862615;
			case 6 -> age /= 29.447498;
			case 7 -> age /= 84.016846;
			case 8 -> age /= 164.79132;
			default -> age = -1;
		}
		return age;
	}
}
