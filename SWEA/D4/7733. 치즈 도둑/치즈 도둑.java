import java.util.Scanner;

public class Solution {
	static int N; // 치즈의 한 변의 길이
	static int[][] dayCheese; // X day - 요정이 치즈 언제 먹는지
//	static boolean[][] eat; // 먹었는지 안 먹었는지
	// 델타
	static int[] di;
	static int[] dj;

	static int maxDay; // 마지막에 먹는 날(맛있는 정도가 최대인 날)
	static int cheese; // 치즈 덩어리 판별
	static int cnt; // 몇 덩어리있는지

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt(); // 치즈 한 변의 길이
			dayCheese = new int[N + 2][N + 2]; // 나중에 범위 지정하기 싫으니까 +2 크기로 만들기
			maxDay = 0;

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (i == 0 || i == N + 1 || j == 0 || j == N + 1) {
						dayCheese[i][j] = 0;
					} else {
						dayCheese[i][j] = sc.nextInt();

						maxDay = Math.max(maxDay, dayCheese[i][j]);
					}
				}
			}



			// 상하좌우 델타
			di = new int[] { -1, 1, 0, 0 };
			dj = new int[] { 0, 0, -1, 1 };

			int cheese = 1;
			for (int day = 1; day <= maxDay; day++) { // 주어진 날짜만큼 돌자


				boolean[][] eat = new boolean[N + 2][N + 2];
				for (int i = 0; i < N + 2; i++) {
					for (int j = 0; j < N + 2; j++) {
						if (i == 0 || i == N + 1 || j == 0 || j == N + 1) {
							eat[i][j] = true; // 벽을 만들었다
						}
					}
				}

				int cnt = 0; // 치즈 덩어리

				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (dayCheese[i][j] <= day) {

							eat[i][j] = true; // 먹은 & 오늘 먹어야 할 치즈면

						}
					}
				}

				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (!eat[i][j]) {// 오늘 날짜에 먹을 치즈가 아니고 이전에도 먹지 않았으면
							cnt++; // 덩어리로 추가해주고

							eat[i][j] = true;
							dfs(i, j, eat); // dayCheese[i][j]와 이어진 치즈 탐색
						}
					}
				}
				cheese = Math.max(cheese, cnt); // 각 날짜의 치즈덩어리 개수와 이전의 최대 치즈 덩어리 개수를 비교
			}

			System.out.println("#" + tc + " " + cheese);

		} // testcase
	} // main

	private static void dfs(int i, int j, boolean[][] eat) {

		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];

			if (eat[ni][nj]) {
				continue;
			} else {
				eat[ni][nj] = true;
				dfs(ni, nj, eat);
			}
		}

	}

}