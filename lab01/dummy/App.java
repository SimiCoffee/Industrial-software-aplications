package dummy;

import java.util.Scanner;

public class App {

	public static void menu() {
		System.out.println("---MENU---");
		System.out.println("1. Hello World");
		System.out.println("2. Amstrong");
		System.out.println("3. Oblicz wiek");
		System.out.println("4. Sekwencja");
		System.out.println("5. Książka");
		System.out.println("0. Exit");
	}

	public static void book() {
		Author author = new Author("Jan Kowalski", "jan@kowalski.mail", Gender.MALE);

		Book book = new Book("W pustyni i w puszczy", 20.0, author);
		System.out.println(book);

		author.setName("Maria Konopnicka");
		author.setEmail("maria@mar.mar");
		author.setGender(Gender.FEMALE);
		book.setName("O dwóch takich, co ukradli księżyc");
		book.setPrice(15.0);
		book.setAuthor(author);
		book.setQty(10);
		System.out.println(book);
	}

	private static boolean isArmstrongInput(Scanner reader) {
		System.out.println("Podaj liczbę");
		int n = reader.nextInt();
		reader.nextLine();
		return Amstrong.isArmstrong(n);
	}

	public static void planetMenu() {
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

	public static String sequenceGenerator(Scanner reader) {
		System.out.println("Podaj liczbę naturalną n: ");
		int n = reader.nextInt();
		reader.nextLine();
		while (n <= 0) {
			System.out.println("Podana liczba musi być większa od 0.");
			System.out.println("Podaj liczbę naturalną n: ");
			n = reader.nextInt();
			reader.nextLine();
		}
		return Sequence.printSequence(n);

	}

	private static double calculateAge(Scanner reader) {
		planetMenu();
		int planetChoice = reader.nextInt();
		reader.nextLine();
		System.out.println("Podaj wiek w sekundach: ");
		int seconds = reader.nextInt();
		reader.nextLine();
		Planet planet = Planet.values()[planetChoice - 1];
		return planet.getAgeByPlanet(seconds);
	}

	public static void testAll() {
		System.out.println("Amstrong, 10: " + (false == Amstrong.isArmstrong(10)));
		System.out.println("Amstrong, 153: " + (true == Amstrong.isArmstrong(153)));
		System.out.println("Amstrong, 9474: " + (true == Amstrong.isArmstrong(9474)));

		// planet
		Planet planet = Planet.EARTH;
		System.out.println("Earth for 1,000,000,000: " +
				(31.68808781402895 == planet.getAgeByPlanet(1000000000)));

		Planet planetMars = Planet.MARS;
		System.out.println("Mars for 1,000,000,000: " +
				(16.848054878116695 == planetMars.getAgeByPlanet(1000000000)));
		// sequence
		System.out.println("Sequence 1: " +
				("x\nxx\nxxx\nxxxx\nxxxxx\nxxxxx\nxxxx\nxxx\nxx\nx\nxxxxx\n xxxx\n  xxx\n   xx\n    x\n    x\n   xx\n  xxx\n xxxx\nxxxxx\n"
						.equals(Sequence.printSequence(5))));
		System.out.println("Sequence 2: "
				+ ("a\naa\naaa\naaaa\naaaaa\naaaaa\naaaa\naaa\naa\na\naaaaa\n aaaa\n  aaa\n   aa\n    a\n    a\n   aa\n  aaa\n aaaa\naaaaa\n"
						.equals(Sequence.printSequence(5, "a"))));

		// book
		Author author = new Author("Jan Kowalski", "jan@kowalski.mail", Gender.MALE);
		Book book = new Book("W pustyni i w puszczy", 20.0, author);
		System.out.println(
				"Book[name=W pustyni i w puszczy, author=Author[name=Jan Kowalski, email=jan@kowalski.mail, gender=Male], price=20.0, qty=0]"
						.equals(book.toString()));
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			menu();
			int option = reader.nextInt();
			reader.nextLine();
			switch (option) {
				case 1 -> helloWorld();
				case 2 -> System.out.println(isArmstrongInput(reader));
				case 3 -> System.out.println(calculateAge(reader));
				case 4 -> System.out.println(sequenceGenerator(reader));
				case 5 -> book();
				case 0 -> exit = true;
				case 88 -> testAll();
				default -> System.out.println("Niepoprawna opcja");
			}
		}
		reader.close();
	}

	public static void helloWorld() {
		System.out.println("Witaj w świecie Java!!!");
	}
}
