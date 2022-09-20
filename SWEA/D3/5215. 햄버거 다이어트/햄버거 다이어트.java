import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt(); //재료의 수
			int kcal = sc.nextInt(); //제한 칼로리
			
			int[] taste = new int[N]; //맛배열
			int[] fKcal = new int[N]; //칼로리배열
			
			for(int i=0; i<N; i++) {
				
				taste[i] = sc.nextInt();
				fKcal[i] = sc.nextInt();
				
			} // 맛, 칼로리 배열 채우기
			
			int maxT = 0; //최대 맛 점수
			for(int i=0; i<(1<<N); i++) { //N개의 재료로 만들 수 있는 부분집합의 개수
				int sumT = 0; //맛 총합
				int sumK = 0; //칼로리 총합
				
				for(int j=0; j<N; j++) { //재료 원소 탐색
					
					if((i & (1<<j))>0) { //i에 j번째 원소가 포함되어 있다면
						sumT += taste[j];
						sumK += fKcal[j];
					}					

				}
				
				if(sumK <= kcal) { //칼로리 총합이 제한된 칼로리보다 작다면
					maxT = Math.max(maxT, sumT); //맛 크기 비교해서 더 큰 값으로 최대 맛점수 갱신
				}
			} //반복문
			
			System.out.println("#"+tc+" "+maxT); //출력
				
		} // 테스트케이스
	} // main

}