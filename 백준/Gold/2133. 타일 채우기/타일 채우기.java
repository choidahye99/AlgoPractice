
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static long ans;
	static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		memo = new int[N + 1];
		Arrays.fill(memo, -1);
		int ans = 0;
		if(N%2 != 0) ans = 0;
		else ans = solve(N);

		System.out.println(ans);

	} // main

	private static int solve(int n) {

		memo[0] = 1;
		memo[2] = 3;

		if (n >= 4) {
			for (int i = 4; i <= n; i += 2) {
				memo[i] = memo[i-2] * 3;
				for(int j=i-4; j>=0; j-=2) { //수열
					memo[i] += (memo[j]*2); //마지막에 memo[0]*2 = 2로 예외경우가 생기는 2를 더해주는 것
				}
//				System.out.println("i: "+i+"\n"+memo[i]);
			}
		}

		return memo[n];
	}

}
