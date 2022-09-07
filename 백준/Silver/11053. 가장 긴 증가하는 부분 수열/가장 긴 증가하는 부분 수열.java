import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //수열의 크기
		
		int[] num = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			num[i] = sc.nextInt();
		}
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(num[j]<num[i]) {
					dp[i] = Math.max(dp[j]+1,dp[i]);
				}
			}
			
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
	}
}
