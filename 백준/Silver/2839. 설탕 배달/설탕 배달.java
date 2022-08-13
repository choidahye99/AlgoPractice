import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 설탕 그램수
		int v = 0; // 봉투 수

		while (N > 0) {

			if (N % 5 == 0) {
				v += N / 5;
				break;
			} else {
				N -= 3;
				v++;
			}

			if (N < 0) {
				v = -1;
			}
		}

		System.out.println(v);

	}
}
