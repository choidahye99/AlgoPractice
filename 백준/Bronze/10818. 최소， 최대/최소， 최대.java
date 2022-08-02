
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//정수의 개수
		int N = sc.nextInt();
		
		int[] num = new int[N];
		
		for(int i=0; i<N; i++) {
			//num 배열에 정수 N개 입력
			num[i]=sc.nextInt();
		}
		
		Arrays.sort(num);
		
		System.out.println(num[0]+" "+num[N-1]);
	}

}
