import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //에너지 드링크 수
		double[] drink = new double[N];
		
		for(int i=0; i<N; i++) {
			drink[i] = sc.nextDouble();
		}
		
		Arrays.sort(drink);
		
		double sum = drink[N-1];
		for(int i=0; i<N-1; i++) {
			sum += drink[i]/2;
		}
		
		System.out.println(sum);
	}

}