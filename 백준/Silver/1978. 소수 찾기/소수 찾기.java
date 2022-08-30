import java.util.Scanner;

public class Main {
	static int[] num;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 숫자 몇개 받을지
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}

		primeNumber(num);

		System.out.println(ans);
	}

	static void primeNumber(int[] num) {

		// 소수가 아니면 true;
		boolean[] check = new boolean[num.length];

		for (int i = 0; i < num.length; i++) {
			if (num[i] == 1 || num[i] == 0) {
				check[i] = true;
			} else {
				for (int j = 2; j < num[i]; j++) {
					int cnt = 0;
					if (num[i] % j == 0)
						cnt++;

					if (cnt > 0)
						check[i] = true;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < num.length; i++) {
			if (!check[i])
				cnt++;
		}

		ans = cnt;

	}
}