package dummy;

import java.util.Scanner;

public class Sequence {
	static String sign = "x";

	public static String printSequence(int maxWidth) {

		StringBuilder result = new StringBuilder();
		for (int i = 1; i <= maxWidth; i++) {
			String repeated = new String(new char[i]).replace("\0", sign);
			result.append(repeated).append("\n");
			// for (int j = 1; j <= i; j++) {
			// System.out.print(sign);
			// }
			// System.out.println();
		}
		for (int i = maxWidth; i >= 1; i--) {
			String repeated = new String(new char[i]).replace("\0", sign);
			result.append(repeated).append("\n");
			// for (int j = 1; j <= i; j++) {
			// System.out.print(sign);
			// }
			// System.out.println();
		}
		for (int i = 1; i <= maxWidth; i++) {

			String repeated = new String(new char[i - 1]).replace("\0", " ");
			String repeated_sign = new String(new char[maxWidth - i + 1]).replace("\0", sign);
			result.append(repeated)
					.append(repeated_sign).append("\n");
			// for (int j = 1; j <= i - 1; j++) {
			// System.out.print(" ");
			// }
			// for (int j = 1; j <= maxWidth - i + 1; j++) {
			// System.out.print(sign);
			// }
			// System.out.println();
		}
		for (int i = maxWidth - 1; i >= 0; i--) {
			String repeated = new String(new char[i]).replace("\0", " ");
			String repeated_sign = new String(new char[maxWidth - i]).replace("\0", sign);
			result.append(repeated)
					.append(repeated_sign).append("\n");
			// for (int j = 1; j <= i; j++) {
			// System.out.print(" ");
			// }
			// for (int j = maxWidth - 1; j >= i; j--) {
			// System.out.print(sign);
			// }
			// System.out.println();

		}
		return result.toString();
	}

	public static String printSequence(int maxWidth, String character) {
		Sequence.sign = character;
		return printSequence(maxWidth);
	}
}
