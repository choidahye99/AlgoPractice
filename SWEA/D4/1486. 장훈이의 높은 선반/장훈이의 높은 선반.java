import java.util.Scanner;

public class Solution {
	static int N; //점원의 수
	static int B; //선반의 높이
	static int[] height; //점원 개개인의 키
	static int ans; //가장 작은 차이
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트케이스
		
		for(int tc=1; tc<=T; tc++) {
			
			N = sc.nextInt();
			B = sc.nextInt();
			
			height = new int[N];
			
			for(int i=0; i<N; i++) {
				height[i] = sc.nextInt();
			}
			
			ans = Integer.MAX_VALUE;
			
			for(int i=1; i<(1<<N); i++) {
				int result=0;
				for(int j=0; j<N; j++) {
					if((i & (1<<j))>0) {
						result += height[j];
					}
				}
				
				if(result >= B) ans = Math.min(ans, result-B);
				else continue;
			}
			
			System.out.println("#"+tc+" "+ans);
		
		}//testCase
	} //main

	private static void search(int idx) {

		
		
	}

	
}