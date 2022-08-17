import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 저수지 크기

			String[][] ground = new String[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ground[i][j] = sc.next();
				}
			}

			// 시계방향 팔방탐색
			int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
			int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };

			int max = 0; // 제일 깊은 물의 깊이
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					int water = 0; // 위치 별 물의 깊이

					for (int d = 0; d < 8; d++) {

						int nr = i + dr[d]; //next row
						int nc = j + dc[d]; //next column

						if (nr >= 0 && nr < N && nc >= 0 && nc < N) { //범위 안으로~
							if (ground[nr][nc].equals("W")) { //String 타입으로 받았으니 equals 사용하여 비교
								water++; // 물이 있으면 +1
							}
						}
					}

					if (water == 0) { //주변에 물이 하나도 없으면
						water = 1;
					}

					max = Math.max(max, water); //제일 깊은 곳 비교해서 넣기
				}
			}

			System.out.println("#"+tc+" "+max);
		}
	}
}