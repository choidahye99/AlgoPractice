import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		double[] score = new double[N];
		
		for(int i=0; i<N; i++) {
			score[i] = sc.nextDouble();
		}
		
		double max = 0;
		for(int i=0; i<N; i++) {
			if(score[i]>max) {
				max = score[i];
			}
		}
		
		double[] nscore = new double[N];
		int ann=0;
		for(int i=0; i<N; i++) {
				
			double result = score[i]/max;
			nscore[ann++] = result*100;
		}
		
		double sum=0;
		for(double i:nscore) {
			sum += i;
		}
		
		double agv = sum/N;
		
		System.out.println(agv);
		
	}

}