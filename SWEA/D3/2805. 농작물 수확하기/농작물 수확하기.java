import java.util.Scanner;

public class Solution {
	static int N;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();//테스트케이스
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); // 농장크기
			int[][] farm = new int[N][N];

			for (int i = 0; i < N; i++) {
				String nutrition = sc.next();
				for (int j = 0; j < N; j++) {
					farm[i][j] = nutrition.charAt(j) - '0'; // 정수로 받아주세용
				}
			}

			ans = 0; // 수확물 총합을 저장할 변수

			int r = N / 2;
			int c = N / 2; // 가운데 좌표

			// 전체를 순회하되
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 해당칸을 보았을 때, r과 c가 변한 거리의 합이 N/2보다 작거나 같으면
					if (Math.abs(r - i) + Math.abs(c - j) <= N / 2) { //Math.abs()는 절대값으로 바꿔주는 좌표
						ans += farm[i][j]; //범위 안에 들어오는 수확물이므로 정답에 추가
					}
				}
			}
			
            System.out.println("#"+tc+" "+ans);
		} //testCase

	}  //main

}