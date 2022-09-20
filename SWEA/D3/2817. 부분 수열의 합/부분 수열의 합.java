import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트케이스
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt(); //원소 개수
			int K = sc.nextInt(); //만들어야 하는 수
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			} //수열 배열 채우기
			
			int cnt = 0; //경우의 수
			for(int i=0; i<(1<<N); i++) { //N개의 원소로 만들 수 있는 부분집합의 개수
				int sum = 0; //원소들의 합
				for(int j=0; j<N; j++) { //원소들을 다 돌아봅시다
					if( (i & (1<<j)) > 0 ) { //(1<<j)가 부분집합 i에 포함된다면
						sum += arr[j];
					}
				}

				if(sum == K) { //합이 만들어야 하는 수와 같다면
					cnt++;
				}
			}
			
			System.out.println("#"+tc+" "+cnt); //출력
			
		} //테스트케이스
	} //main

}
