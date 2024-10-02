package dummy;

import java.util.Scanner;

public class Amstrong {

	public static boolean isArmstrong(Scanner reader) {
		System.out.println("Podaj liczbę");
		int n = reader.nextInt();
		reader.nextLine();
		int sum = 0;
		int temp = n;
		int length = String.valueOf(n).length();
		while (temp != 0) {
			int digit = temp % 10;
			sum += Math.pow(digit, length);
			temp /= 10;
		}
		return sum == n;
	}

}
