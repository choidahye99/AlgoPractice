import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트케이스
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); //배열 A의 크기
			int M = sc.nextInt(); //배열 B의 크기
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			for(int i=0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			for(int i=0; i<M; i++) {
				B[i] = sc.nextInt();
			}
			//배열 A,B 채우기
			
			if(N<M) { //배열 A가 배열 B보다 작을 때
				int[] mult = new int[M-N+1]; //M-N+1개의 합이 만들어질 예정
				for(int k=0; k<=M-N; k++) { 
					int i=0;
					int j=k; //i가 한칸씩 왼쪽으로 이동할 거니까 j도 거기에 맞게 이동 //그게 k랑 일치해용
					while(i<N) { //i가 범위 안에 있을 때
					mult[k] += A[i]*B[j]; //서로 마주보고 있는 숫자끼리 곱해서 계속 더하기
					i++;
					j++;
					}
				}
				int max = 0;
				for(int i:mult)
				max = Math.max(max, i); //마주보는 수를 곱한 값의 총합들 중 가장 큰 수 
				
				System.out.println("#"+tc+" "+max);
				
			} else { //A가 B보다 클 때 
				int[] mult = new int[N-M+1];
				for(int k=0; k<=N-M; k++) {
					int i=0;
					int j=k;
					while(i<M) {
					mult[k] += A[j]*B[i]; //B가 이동하므로 A가 B에 맞춰서 인덱스 변경
					i++;
					j++;
					}
				}
				int max = 0;
				for(int i:mult)
				max = Math.max(max, i);
				
				System.out.println("#"+tc+" "+max);
			}
		}//tc
	} //main

}