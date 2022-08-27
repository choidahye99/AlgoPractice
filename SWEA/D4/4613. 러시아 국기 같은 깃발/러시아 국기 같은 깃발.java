import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 세로줄 수
			int M = sc.nextInt(); // 가로줄 수

			int[][] Russia = new int[N][M];
			for (int i = 0; i < N; i++) {
				String colorLine = sc.next();
				for (int j = 0; j < M; j++) {
					Russia[i][j] = colorLine.charAt(j);
				}
			}

			int changeColor = 0;
			for (int i = 0; i < M; i++) {
				if (Russia[0][i] != 'W') {
					Russia[0][i] = 'W';
					changeColor++;
				}
				if (Russia[N - 1][i] != 'R') {
					Russia[0][i] = 'R';
					changeColor++;
				}
			}

			////////////////////////////
			int change = 0;
			int min = Integer.MAX_VALUE;
			for (int w = 0; w < N - 2; w++) {
				for (int b = 1; b < N - 1 - w; b++) {
					change = 0;
					for (int i = 0; i < N - 2 - w - b; i++) {
						for (int j = 0; j < M; j++) {
							if (Russia[N - 2 - i][j] != 'R')
								change++;
						}
					}
					for (int i = 1; i <= b; i++) {
						for (int j = 0; j < M; j++) {
							if (Russia[w + i][j] != 'B')
								change++;
						}
					}

					for (int i = 0; i < w; i++) {
						for (int j = 0; j < M; j++) {
							if (Russia[1 + i][j] != 'W')
								change++;
						}
					}
					min = Math.min(min, change);
				}
			}

			int result = changeColor + min;
			System.out.println("#"+tc+" "+result);

		}
	}

}