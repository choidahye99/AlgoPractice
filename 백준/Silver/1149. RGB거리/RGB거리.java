import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] colorPrice = new int[N + 1][4];
		int[][] dp = new int[N + 1][4];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 3; j++) {
				colorPrice[i][j] = sc.nextInt();
			}
		} // 각 집마다 빨강, 초록, 파랑으로 칠할 때 드는 비용 입력

		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 3; j++) {
				if (i == 1) {
					dp[i][j] = colorPrice[i][j];
				} else {

					int c = colorPrice[i][j];
					if(j==1) dp[i][1] = Math.min(dp[i - 1][2] + c, dp[i - 1][3] + c); //빨강
					else if(j==2) dp[i][2] = Math.min(dp[i - 1][1] + c, dp[i - 1][3] + c); //초록
					else dp[i][3] = Math.min(dp[i - 1][1] + c, dp[i - 1][2] + c); //파랑
				}
			}
		}
		
		for(int i=1; i<=3; i++) {
			min = Math.min(dp[N][i], min);
		}
		
		System.out.println(min);
		

	}

}