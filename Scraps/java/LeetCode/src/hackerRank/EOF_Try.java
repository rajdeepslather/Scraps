package hackerRank;

import java.util.Scanner;

public class EOF_Try {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 1;
		while (sc.hasNext())
			System.out.println(i++ + " " + sc.nextLine());
	}
}