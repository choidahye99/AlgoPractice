import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		
		double[] tcs = new double[C];
		
		for(int tc=0; tc < C; tc++) {
			
			//학생수
			int N = sc.nextInt();
			
			//점수배열
			int[] score = new int[N];
			for(int i=0; i<N; i++) {
				score[i] = sc.nextInt();
			}
			
			//점수총합
			int sum=0;
			for(int i:score) {
				sum += i;
			}
			
			//평균
			float avg = sum/N;
			
			//평균을 넘는 학생들의 수
			int cnt=0;
			for(int i:score) {
				if(i>avg) {
					cnt++;
				}
			}
			
			double students = (double) cnt/N;
			
			//평균을 넘는 학생들의 비율
			students = students*100;
			
			tcs[tc] = students;
		}
		
		for(int i=0; i<C; i++) {
			System.out.printf("%.3f%s", tcs[i], "%\n");
		}
	}

}
