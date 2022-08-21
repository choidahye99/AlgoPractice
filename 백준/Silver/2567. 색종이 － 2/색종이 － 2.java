import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 색종이 장수
		int[][] paper = new int[102][102]; // 도화지 넓이. 도화지 경계에 있는 색종이 둘레도 델타 이용할 거니까 도화지 상하좌우 +1씩 넓게

		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				paper[i][j] = 0;
			}
		} // 새하얀 도화지 준비~

		int k = 0;
		while (k < N) {
			int x = sc.nextInt(); // x좌표
			int y = sc.nextInt(); // y좌표

			for (int i = x+1; i <= x + 10; i++) {
				for (int j = y+1; j <= y + 10; j++) {
					paper[i][j] = 1;
				}
			} //넓이만큼

			k++;
		} // 도화지를 채워용

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 }; //델타

		int sum = 0; // 둘레 합
		
		// 탐색해봅시다
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];

					if (nr >= 0 && nr < 102 && nc >= 0 && nc < 102) { //범위 안에서 탐색. 둘레에 변이 있는 색종이가 없는 경우
						if (paper[nr][nc] == 0 && paper[i][j] == 1) { //0과 1이 인접해있으면
							sum++; //둘레합에 +1
						}
					}
				}
			}
		}

		System.out.println(sum);
	}
}