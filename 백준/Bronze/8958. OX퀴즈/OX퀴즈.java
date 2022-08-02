import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {

			String ans = sc.next();
			int len = ans.length();

			char[] anss = ans.toCharArray();

			int[] score = new int[len];
			int k = 0;
			int t = 1;

			for (int j = 0; j < len; j++) {
				if (anss[j] == 'O') {

					score[k++] = t;
					++t;

				} else {
					score[k++] = 0;
					t = 1;
				}
			}

			int sum = 0;
			for (int d : score) {
				sum += d;
			}
			System.out.println(sum);
		}
	}

}