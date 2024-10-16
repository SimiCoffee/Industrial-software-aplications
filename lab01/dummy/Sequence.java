package dummy;

import java.util.Scanner;

public class Sequence {
	private static String sign = "x";

	public static String printSequence(int maxWidth) {

		StringBuilder result = new StringBuilder();
		for (int i = 1; i <= maxWidth; i++) {

			result.append(sign.repeat(i)).append("\n");
			// for (int j = 1; j <= i; j++) {
			// System.out.print(sign);
			// }
			// System.out.println();
		}
		for (int i = maxWidth; i >= 1; i--) {
			result.append(sign.repeat(i)).append("\n");
			// for (int j = 1; j <= i; j++) {
			// System.out.print(sign);
			// }
			// System.out.println();
		}
		for (int i = 1; i <= maxWidth; i++) {

			result.append(" ".repeat(i - 1))
					.append(sign.repeat(maxWidth - i + 1)).append("\n");
			// for (int j = 1; j <= i - 1; j++) {
			// System.out.print(" ");
			// }
			// for (int j = 1; j <= maxWidth - i + 1; j++) {
			// System.out.print(sign);
			// }
			// System.out.println();
		}
		for (int i = maxWidth - 1; i >= 0; i--) {
			result.append(" ".repeat(i))
					.append(sign.repeat(maxWidth - i)).append("\n");
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

	public static String printSequence(int maxWidth, String sign) {
		Sequence.sign = sign;
		return printSequence(maxWidth);
	}
}
