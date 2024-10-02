package dummy;

import java.util.Scanner;

public class App {

	public static void menu() {
		System.out.println("---MENU---");
		System.out.println("1. Hello World");
		System.out.println("2. Amstrong");
		System.out.println("0. Exit");
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			menu();
			int option = reader.nextInt();
			switch (option) {
				case 1 -> helloWorld();
				case 2 -> System.out.println(Amstrong.isArmstrong();
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
