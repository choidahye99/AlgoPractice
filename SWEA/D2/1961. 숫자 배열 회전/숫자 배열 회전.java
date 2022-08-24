import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); //테스트케이스
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			} // 숫자 담기

			// 90도
			int[][] newArr = new int[N][N];
			for (int i = N - 1; i >= 0; i--) {
				for (int j = N - 1; j >= 0; j--) {
					newArr[(N - 1) - j][(N - 1) - i] = arr[i][(N - 1) - j];
				}
			}

			// 180도
			int[][] newArr2 = new int[N][N];
			for (int i = N - 1; i >= 0; i--) {
				for (int j = N - 1; j >= 0; j--) {
					newArr2[(N - 1) - j][(N - 1) - i] = newArr[i][(N - 1) - j];
				}
			}

			// 270도
			int[][] newArr3 = new int[N][N];
			for (int i = N - 1; i >= 0; i--) {
				for (int j = N - 1; j >= 0; j--) {
					newArr3[(N - 1) - j][(N - 1) - i] = newArr2[i][(N - 1) - j];
				}
			}

			//출력
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(newArr[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(newArr2[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(newArr3[i][j]);
				}
				System.out.print(" ");
				if(i!=N-1)
				System.out.println();
			}
							System.out.println();
		}
		
	} //main

}