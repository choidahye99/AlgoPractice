import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] num = new int[N+1];
		for(int i=1; i<=N; i++) {
			num[i] = sc.nextInt() + num[i-1];
		} //누적합 배열
		
		int M = sc.nextInt();
		for(int i=0; i<M; i++) { //M번의 계산
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			System.out.println(num[end]-num[start-1]); //(첫번째~end번째까지 누적합) - (start 이전까지 누적합)
			
		}
	}

}