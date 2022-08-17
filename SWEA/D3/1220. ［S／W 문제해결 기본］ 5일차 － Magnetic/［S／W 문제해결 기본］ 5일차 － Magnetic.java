import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); // 크기

			int[][] ground = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ground[i][j] = sc.nextInt();
				}
			}

			int count = 0; //교착상태 개수 구하기
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) { //열 탐색
					if (ground[i][j] == 1) { //위쪽이 N극이므로 밀어내는 1 성질의 자성체로 시작해야 함
						for (int k = i + 1; k < N; k++) { //1 성질의 자성체 아래쪽 탐색
							if (ground[k][j] == 2) { //S가 아래이므로 2성질의 자성체 찾으면 교착상태 가능
								i = k; //위 반복문에서 k++을 해주기 때문에 절대 k+1이라고 하면 안됨 ㅠㅠㅠㅠㅠ 여기서 20분 고민함..
								count++;
								break; //2 찾았으니 그 아래 탐색은 멈추고 다시 1 찾으러 갑시다
							} else continue;
						}
					} else continue;
				} 
			}

			System.out.println("#"+tc+" "+count);

		}
	}
}