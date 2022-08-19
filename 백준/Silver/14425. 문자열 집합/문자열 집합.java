import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String arr[] = new String[N];
		int result = 0;
		for(int i=0; i<N; i++) {
			arr[i] = sc.next();
		}
		
		for(int i=0; i<M; i++) {
			String str = sc.next();
			for(int j=0; j<N; j++) {
				if(str.equals(arr[j])) {
					result++;
					break;
				}
			}
		}
		
		System.out.println(result);
	}
	
	
}