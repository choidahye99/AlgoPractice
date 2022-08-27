import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 세로줄 수
			int M = sc.nextInt(); // 가로줄 수

			int[][] Russia = new int[N][M]; //국기
			
			for (int i = 0; i < N; i++) {
				String colorLine = sc.next();
				for (int j = 0; j < M; j++) {
					Russia[i][j] = colorLine.charAt(j);
				}
			} //입력받은 색깔 채우기

			int changeColor = 0; //맨 윗줄, 맨 아래줄에서 색깔 몇번 바뀌는지
			for (int i = 0; i < M; i++) {
				if (Russia[0][i] != 'W') {
					Russia[0][i] = 'W';
					changeColor++; //하얀색이 아니면 하얀색으로 바꾸고 숫자 바꿨다고 +1
				}
				if (Russia[N - 1][i] != 'R') {
					Russia[0][i] = 'R';
					changeColor++; //빨간색이 아니면 빨간색으로 바꾸고 숫자 바꿨다고 +1
				}
			}

			////////////////////////////
			int change = 0; //맨위, 맨아래 제외 중간에서 바뀌는 숫자들
			int min = Integer.MAX_VALUE; //색깔이 최소로 바뀌는 경우는??
			for (int w = 0; w < N - 2; w++) { //하얀색 줄은 N줄 중 맨위, 맨아래, 파랑최소 한 줄 개수 제외하고 존재할 수 있음
				for (int b = 1; b < N - 1 - w; b++) { //파란색은 무조건 한 줄이상. 맨마지막은 빨강줄이 있으니까 N-1줄까지 존재 가능
					change = 0; //바뀐 숫자 체크
					for (int i = 0; i < N - 2 - w - b; i++) { //빨간색. N-2개에서 하얀색줄 빼고 파란색줄 개수 뺀 개수만큼 올 수 있음
						for (int j = 0; j < M; j++) {
							if (Russia[N - 2 - i][j] != 'R')
								change++; //빨간색으로 바꿨다 +1
						}
					}
					for (int i = 1; i <= b; i++) { //파란줄 b개 돌리자
						for (int j = 0; j < M; j++) {
							if (Russia[w + i][j] != 'B') //w가 온 다음줄부터 파란 줄을 채울 수 있으므로 w+i가 좌표가 됨
								change++; //파란줄 바꿨다
						}
					}

					for (int i = 0; i < w; i++) {
						for (int j = 0; j < M; j++) {
							if (Russia[1 + i][j] != 'W') //첫줄은 이미 하얀줄이므로 1+w부터 채워야 함 (w가 1개일 때 i=0으로 시작하므로)
								change++;
						}
					}
					min = Math.min(min, change); //이번턴에 색깔 몇개 바꼈는지와 이전까지 최소였던 바뀐 색깔 개수 비교해서 최소값 갱신
				}
			}

			int result = changeColor + min; //첫줄, 맨 마지막줄 바뀐 숫자 + 최소한으로 바뀐 개수
			System.out.println("#"+tc+" "+result);

		}
	}

}