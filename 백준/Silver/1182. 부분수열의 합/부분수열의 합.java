import java.util.Scanner;

public class Main {
	static int N;
	static int S;
	static int[] arr;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정수의 개수
		S = sc.nextInt(); // 원소를 다 더했을 때 나와야 하는 값

		arr = new int[N];
		check = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		ans = 0;

		powerSet(0);

		if(S==0) {
			ans--;
		} //전부다 false일 경우에 sum이 0으로 ans값이 하나 출력되므로 -1 해줘야 함
		
		System.out.println(ans);

	}

	static int ans = 0;

	public static void powerSet(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (check[i]) {
					sum += arr[i];
				}
			}
			if (sum == S) {
				ans++;
			}
			return;
		}

		check[idx] = true;
		powerSet(idx + 1);
		check[idx] = false;
		powerSet(idx + 1);
	}
}