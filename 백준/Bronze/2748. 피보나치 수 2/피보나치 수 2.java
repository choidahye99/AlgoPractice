import java.util.Scanner;

public class Main {
	// 시간초과가 떠버렸다..
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		
//		System.out.println(fibo(n));
//	}
//	
//	public static int fibo(int n) {
//		if(n==0) return 0;
//		if(n==1) return 1;
//		
//		return fibo(n-1)+fibo(n-2);
//	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.println(fibo(n));
	}

	public static long fibo(int n) {
		long[] answer = new long[n + 1]; // 피보나치를 담을 배열. n번까지의 인덱스를 가짐

		for (int i = 0; i <= n; i++) {

			if (i == 0) {
				answer[i] = 0;
			} else if (i == 1) {
				answer[i] = 1;
			}
			else {
				long sum = answer[i - 2] + answer[i - 1]; // 피보나치
				answer[i] = sum ;
			}
		}

		return answer[n];
	}

}