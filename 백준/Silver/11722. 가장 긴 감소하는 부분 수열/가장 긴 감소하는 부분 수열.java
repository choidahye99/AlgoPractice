import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //수의 개수
		
		int[] num = new int[N+1]; //1부터 쓰겠음당
		int[] dp = new int[N+1]; 
		
		for(int i=1; i<=N; i++) {
			num[i] = sc.nextInt();
		}
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(num[j]>num[i]) { //j번째에 더 큰 수가 있을 경우
					dp[i] = Math.max(dp[i], dp[j]+1); //dp[j]가 가지고 있는 길이에 +1 누적한 값과 자기가 지금 가지고 있는 길이 비교해서 큰 값
				}
			}
			
			ans = Math.max(ans, dp[i]); //범위값이 바뀔 때마다 최대값 구해서 정답 도출
		}
		
		System.out.println(ans);
	}

}