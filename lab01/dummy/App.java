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

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			menu();
			int option = reader.nextInt();
			reader.nextLine();
			switch (option) {
				case 1 -> helloWorld();
				case 2 -> System.out.println(Amstrong.isArmstrongInput(reader));
				case 3 -> System.out.println(Seconds.calculateAgeInput(reader));
				case 4 -> Sequence.app(reader);
				case 5 -> book();
				case 0 -> exit = true;
				default -> System.out.println("Niepoprawna opcja");
			}
		}
		reader.close();
	}

	public static void helloWorld() {
		System.out.println("Witaj w świecie Java!!!");
	}
}
