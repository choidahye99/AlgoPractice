import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 동전의 수
		int N = sc.nextInt();

		int[] round1 = new int[N];
		int[] round2 = new int[N];

		for (int i = 0; i < N; i++) {
			round1[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			round2[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			// 양수합
			if (round1[i] < 0) {
				round1[i] *= (-1);
			} else
				continue;
		}

		// 움수합
		for (int i = 0; i < N; i++) {
			if (round2[i] > 0) {
				round2[i] *= (-1);
			} else
				continue;
		}

		int sum = 0;

		for (int i : round1) {
			sum += i;
		}

		int sum2 = 0;
		for (int i : round2) {
			sum2 += i;
		}

		System.out.println(sum - sum2);
	}

}
