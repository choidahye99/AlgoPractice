import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int D = sc.nextInt(); //날짜
		int K = sc.nextInt(); //내 떡 ㅠㅠ
		int[][] dp = new int[D][2]; //A, B 떡의 비율
		
		dp[0][0] = 1; //첫째날 
		dp[1][1] = 1; //둘째날
		
		for(int i=2; i<D; i++) {
			dp[i][0] = dp[i-2][0]+dp[i-1][0];
			dp[i][1] = dp[i-2][1]+dp[i-1][1];
		}

		int A = 1;
		int B = 0;
		
		int a = dp[D-1][0]; //A를 몇번 사용했는지
		int b = dp[D-1][1]; //B를 몇번 사용했는지
		int k = K-a;
		
//		for(int[] i:dp) {
//			for(int j: i) {
//				System.out.print(j+" ");
//			}
//			System.out.println();
//		}
		
		while(k!=0) {
			
			if(k%b==0) {
				B = k/b;
				break;
			} else {
				k = k-a;
				A++;
			}
			
		}
		
		System.out.println(A);
		System.out.println(B);
		
		
	}

}