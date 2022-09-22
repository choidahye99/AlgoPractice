
import java.util.Scanner;

public class Solution {
	static int N;
	static int M;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			
			int T = sc.nextInt(); //테스트케이스
			N = sc.nextInt(); //밑수
			M = sc.nextInt(); //지수

//			int ans = (int) Math.pow(N, M);
			
			result = 1;
			pow(1);
			
			System.out.println("#"+tc+" "+result);
			
		}
	}
	
	static void pow(int idx) {
		//탈출 조건
		if(idx > M) {
			return;
		}
		
		result *= N;
		pow(idx+1);
		
	}

}