import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long a = 0;
		long b = 1;
		
		for(int i=0; i<N-1; i++) {
			long temp = a;
			a = b;
			b = temp+a;
		}
		
		System.out.println(b);
	}

}