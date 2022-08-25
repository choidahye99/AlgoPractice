
import java.util.Scanner;

public class Solution {
	static int N; // 판 크기
	static int[][] field; // 오목판 상태

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 오목판 크기
			field = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = sc.next(); // 오목 한줄 입력
				for (int j = 0; j < N; j++) {
					char k = str.charAt(j);
					if (k == '.') {
						field[i][j] = 0;
					} else {
						field[i][j] = 1;
					}
				}
			}

			System.out.print("#" + tc + " ");
			if (right() || down() || diagonal()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		} // testCase
	}// main

	// 행탐색
	static boolean right() {

		for(int i=0; i<N; i++) {
			int oneCnt = 0;
			for(int j=0; j<N; j++) {
				if(field[i][j]==1) {
					oneCnt++;
					if(oneCnt>=5) return true;
				} else {
					oneCnt = 0;
				}
			}
		}
		return false;
	}

	// 열탐색
	static boolean down() {

		for(int j=0; j<N; j++) {
			int oneCnt = 0;
			for(int i=0; i<N; i++) {
				if(field[i][j]==1) {
					oneCnt++;
					if(oneCnt>=5) return true;
				} else {
					oneCnt = 0;
				}
			}
		}
		return false;
	}

	// 대각선 탐색
	static boolean diagonal() {
		int[] dc = { 1, 1 };
		int[] dr = { -1, 1 };

		for (int i = 0; i < N-4; i++) {
			int oneCnt = 0;
			for (int j = 0; j < N; j++) {
				if (field[i][j] == 1) {
					if (j == 0) { // 왼쪽 벽에 붙는 경우 오른쪽 아래로만
						oneCnt = 1;
						int add = 1;
						while (true) {
							int nc = i + dc[1] * add;
							int nr = j + dr[1] * add;

							if (nc >= 0 && nc < N && nr >= 0 && nr < N) {
								if (field[nc][nr] == 1) {
									oneCnt++;
									add++;
									if (oneCnt >= 5)
										return true;
								} else break;
							} else
								break;

						}
					} else if (j == N - 1) { // 오른쪽 벽에 붙는 경우 왼쪽 아래로만
						oneCnt = 1;
						int add = 1;
						while (true) {
							int nc = i + dc[0] * add;
							int nr = j + dr[0] * add;

							if (nc >= 0 && nc < N && nr >= 0 && nr < N) {
								if (field[nc][nr] == 1) {
									oneCnt++;
									add++;
									if (oneCnt >= 5)
										return true;
								} else break;
									
							} else
								break;

						}
					} else {
						if (field[i + 1][j - 1] == 1) {
							oneCnt = 1;
							int add = 1;
							while (true) {
								int nc = i + dc[0] * add;
								int nr = j + dr[0] * add;

								if (nc >= 0 && nc < N && nr >= 0 && nr < N) {
									if (field[nc][nr] == 1) {
										oneCnt++;
										add++;
										if (oneCnt >= 5)
											return true;
									} else
										break;
								} else
									break;

							}

						} 
						
						if (field[i + 1][j + 1] == 1) {
							oneCnt = 1;
							int add = 1;
							while (true) {
								int nc = i + dc[1] * add;
								int nr = j + dr[1] * add;

								if (nc >= 0 && nc < N && nr >= 0 && nr < N) {
									if (field[nc][nr] == 1) {
										oneCnt++;
										add++;
										if (oneCnt >= 5)
											return true;
									} else
										break;
								} else
									break;

							}
						}

					}
				} // 조건 : field[i][j] == 1
			} // j좌표
		} // i좌표
		return false;
	}

}
