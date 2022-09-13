import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] num = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String nums = sc.next();
			for(int j=1; j<=M; j++) {
				num[i][j] = nums.charAt(j-1)-'0';
			}
		} //숫자 입력
		
		for(int i=1; i<=M; i++) {
			dp[1][i] = num[1][i]; //첫줄은 1로 초기화
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				int min = Integer.MAX_VALUE;
				if(num[i][j]==1) { //1이 있는 곳을 정사각형의 제일 우측 하단이라고 생각
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1; //num[i][j]를 우측 모서리로 하는 정사각형 한 변의 길이는 [대각선왼쪽위, 위, 왼쪽]값 중 최소값 +1
				}
			}
		}
		
		int max = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				max = Math.max(dp[i][j], max);
			}
		} //가장 큰 정사각형 한 변의 길이
		
		System.out.println(max*max); //넓이
		
	} //main
}