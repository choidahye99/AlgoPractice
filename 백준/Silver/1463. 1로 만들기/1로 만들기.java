import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int arr[] = new int[N+1];
		
		arr[0] = -1;
		arr[1] = 0;
		
		for(int i=2; i<N+1; i++) {
			
			
			int min = arr[i-1]+1;
			if(i%2 ==0) {
				if(min>arr[i/2]+1) min = arr[i/2]+1;
			}
			if(i%3 ==0) {
				if(min>arr[i/3]+1) min = arr[i/3]+1;
			}
			arr[i] = min;
		}
		
		System.out.println(arr[N]);
	}
}