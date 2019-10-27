package hackerRank;

import java.util.Scanner;

public class StdinTry {

	public static void main(final String[] args) {
		final Scanner scan = new Scanner(System.in);
		final int a = scan.nextInt();
		final int b = scan.nextInt();
		final int c = scan.nextInt();
		scan.close();

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

	}

	public static void main2(final String[] args) {
		final Scanner scan = new Scanner(System.in);
		final int i = scan.nextInt();
		final Double d = scan.nextDouble();
		// Skip last new line
		scan.nextLine();
		final String s = scan.nextLine();

		System.out.println("String: " + s);
		System.out.println("Double: " + d);
		System.out.println("Int: " + i);
	}
}
