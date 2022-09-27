import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		System.out.println(pow(A, B, C));
	
	
	}

	
	private static long pow(int A, int B, int C) {
		
		//탈출조건
		if(B == 1) return A % C;
		
		long result;
		//유도 조건

		if(B%2 == 0) {//짝수
			
			result = pow(A, B/2, C);
			
			return ( result * result ) % C;
			
		} else { //홀수
			
			result = pow(A, (B-1)/2, C);
			
			return (( (result * result) % C) * A ) % C;
			
		}
		
	}
	
}
