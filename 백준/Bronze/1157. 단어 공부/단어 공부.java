import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String sentence = sc.next();
		char[] word = new char[sentence.length()];

		for (int i = 0; i < sentence.length(); i++) {
			word[i] = sentence.charAt(i);

			if (97 <= sentence.charAt(i) && sentence.charAt(i) <= 122) {
				word[i] = (char) (sentence.charAt(i) - 32);
			}
		}

		int[] num = new int[123];

		for (int i = 0; i < sentence.length(); i++) {
			num[word[i] - 'A']++;
		}

		int maxIdx = 0;
		int max = 0;
		int cnt = 0;
		for (int i = 0; i < 123; i++) {
			if (max < num[i]) {
				max = num[i];
			}
		}

		for (int i = 0; i < 123; i++) {
			if (num[i] == max) {
				cnt++;
				maxIdx = i;
			}
		}
		if (cnt == 1) {
			char alp = (char) (maxIdx + 'A');
			System.out.println(alp);
		} else if (cnt > 1) {
			System.out.println("?");
		}
	}

}