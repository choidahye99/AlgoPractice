import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		int m = B + C;
		int h = A + m / 60;
		if (h < 24) {
			System.out.println(h + " " + (m % 60));
		} else {
			h = h - 24;
			System.out.println(h + " " + (m % 60));
		}

	}

}