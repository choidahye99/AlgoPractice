import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //정수의 개수
		int M = sc.nextInt(); //합의 개수
		
		int[] arr = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = arr[i-1] + sc.nextInt();
		}
		
		
		while(M>0) {
		int i = sc.nextInt();
		int j = sc.nextInt();
		
		System.out.println(arr[j] - arr[i-1]);
		M--;
		}
	}
}