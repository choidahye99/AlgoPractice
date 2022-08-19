import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N= sc.nextInt();
		
		double arr[] = new double[N];
		double max = 0;
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextDouble();
			if(max < arr[i])  max = arr[i];
		}
		double sum = 0;
		for(int i=0; i<N; i++) {
			sum += (arr[i]/max)*100;
		}
		
		System.out.println(sum/N);
		
		

	}

}