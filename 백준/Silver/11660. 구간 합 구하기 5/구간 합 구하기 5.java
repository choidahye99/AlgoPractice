import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 표의 크기
		int M = sc.nextInt(); // 구해야 하는 횟수

		int[][] num = new int[N + 1][N + 1];
		int[][] dp = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				num[i][j] = sc.nextInt();
			}
		} // 숫자 입력받기

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 원래 제시된 숫자의 위쪽 전체 합 +왼쪽 전체합 +중복된 합+본인자리
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + num[i][j];
			}
		} // dp 누적합 만들기

		for(int i=0; i<M; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();

			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			//큰 사각형 - (포함되지 않는 위쪽 사각형 + 포함되지 않는 왼쪽 사각형 - 중복합)
			int ans = dp[x2][y2]-(dp[x1-1][y2]+dp[x2][y1-1]-dp[x1-1][y1-1]);
			
			System.out.println(ans);
		}

	} // main

}