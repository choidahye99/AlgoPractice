
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt(); //물건 총합
		
		int N = sc.nextInt(); //물건개수
		
		for(int i=0; i<N; i++) {
			int a = sc.nextInt(); //물건 가격
			int b = sc.nextInt(); //물건 개수
			
			X = X-(a*b);
		}
		
		if(X==0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
