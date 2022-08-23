import java.util.Arrays;
//최소 공약수 문제
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //몇개의 링
		
		int num1 = sc.nextInt(); //기준링
		int[][] num  = new int[N-1][2];
		
		for(int i=0; i<N-1; i++) {
				int num2 = sc.nextInt();
				num[i][0] = num1/gcf(num1, num2);
				num[i][1] = num2/gcf(num1, num2);
		}
		
		for(int i=0; i<N-1; i++) {
			System.out.println(num[i][0]+"/"+num[i][1]);
		}

	
	} // main		
	public static int gcf(int num1, int num2) { //greatest common factor
		int temp;
		
		while(num2!=0) {
			temp = num1%num2; //나머지를 계속 구하다보면
			num1 = num2; // num2, 즉 num1%num2를 0으로 만드는 최소공약수가 num2에 남게 되고
			num2 = temp; //0이 되므로 while문 닫힘
		}
		
		return num1; //최소공약수
	}
}