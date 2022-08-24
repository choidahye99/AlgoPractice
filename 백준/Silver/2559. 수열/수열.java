import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //날짜 수
		int K = sc.nextInt(); //며칠 연속으로 합칠 건지
		
		int[] temperature = new int[N];
		for(int i=0; i<N; i++) {
			temperature[i] = sc.nextInt();
		}
		
		int maxSum = Integer.MIN_VALUE; //정수 중에 음수도 있으므로
		for(int i=0; i<=N-K; i++) {
			int sum = 0;
			for(int j=i; j<K+i; j++) { //i부터 연속적인 K개의 숫자를 보고 싶을 때 쓰는 반복문
				sum += temperature[j];
			}
			maxSum = Math.max(sum, maxSum);
		}
		
		System.out.println(maxSum);
	} //main
}