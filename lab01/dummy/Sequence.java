package dummy;

import java.util.Scanner;

// Napisz program, który dla liczby naturalnej \( n \) wypisze poniższe wzory (jeden pod drugim). Poniżej jest przykład dla n=3.
// W przypadku niepoprawnych danych program ma ponownie je wczytać.
// Zakładamy, że na końcu linii jest wyłącznie znak nowej linii.
// x
// xx
// xxx
// xxx
// xx
// x
// xxx
//   xx
//    x
//    x
//   xx
// xxx

public class Sequence {
	public static void printSequence(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("x");
			}
			System.out.println();
		}
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("x");
			}
			System.out.println();
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= n - i + 1; j++) {
				System.out.print("x");
			}
			System.out.println();
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = n - 1; j >= i; j--) {
				System.out.print("x");
			}
			System.out.println();
		}
	}

	public static void app(Scanner reader) {
		System.out.println("Podaj liczbę naturalną n: ");
		int n = reader.nextInt();
		reader.nextLine();
		while (n <= 0) {
			System.out.println("Podana liczba musi być większa od 0.");
			System.out.println("Podaj liczbę naturalną n: ");
			n = reader.nextInt();
			reader.nextLine();
		}
		printSequence(n);
	}
}
