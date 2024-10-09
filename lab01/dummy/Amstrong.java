package dummy;

import java.util.Scanner;

public class Amstrong {

	public static boolean isArmstrong(int n) {
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
