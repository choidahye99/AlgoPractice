import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 배열 크기

			int[][] nums = new int[N][N];

			int num = 1;

			int k = 0; // 다음줄?로 넘어갈 때 j값 조절하는 변수
			int i = (N - 1); // 방향전환 용도,, N-1에서 방향전환 시킴

			if (N % 2 == 0) { //홀수랑 짝수 규칙이 달라서 나눠줌
				while (true) {
					if (num >= N * N)
						break; // N*N 숫자 다 채워지면 while문 종료

					for (int j = k; j < i; j++) {
						nums[k][j] = num++;
					} // 가로줄1

					for (int j = k; j < i; j++) {
						nums[j][i] = num++;
					} //세로줄1

					for (int j = k; j < i; j++) {
						nums[i][(N - 1) - j] = num++;
					} // 가로줄2(역순)

					for (int j = k; j < i; j++) {
						nums[(N - 1) - j][k] = num++;
					} //세로줄2(역순)

					k++; //한바퀴 돌면 j가 +1부터 시작이므로 조절
					i--; //한바퀴 돌면 i도 기존보다 -1한 부분까지만 채워야 하므로 조절 

				}
			} else {
				while (true) {

					if (k == i)
						nums[i][i] = num++; //짝수와 다른점,, 홀수는 가운데위치(i,i)에 수가 들어가기 때문에 추가

					if (num >= N * N)
						break; // N*N 숫자 다 채워지면 while문 종료

					for (int j = k; j < i; j++) {
						nums[k][j] = num++;
					}

					for (int j = k; j < i; j++) {
						nums[j][i] = num++;
					}

					for (int j = k; j < i; j++) {
						nums[i][(N - 1) - j] = num++;
					}


					for (int j = k; j < i; j++) {
						nums[(N - 1) - j][k] = num++;
					}

					k++;
					i--;
				}

			}
			
			System.out.println("#"+tc);
			for(int x=0; x<N; x++) {
				for(int y=0; y<N; y++) {
					System.out.print(nums[x][y]+" ");
				}
				System.out.println(); // 줄바꿈 꼭!!
			}

		}

	}
}