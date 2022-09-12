import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //삼각형의 크기
		
		int[][] triangle = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) { //0번째 행부터 아래로 갈 수록 숫자가 하나씩 증가함
				triangle[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1; i<N; i++) { //1번째 행부터
			for(int j=0; j<=i; j++) {
				
				if(j-i==0) { //제일 오른쪽 대각선 계산
					triangle[i][j] += triangle[i-1][j-1];
				} else if (j-1>=0) { //중간에 두 개의 부모를 가지는 자식 노드
					//왼쪽 부모는 자기 위치보다 j-1에 위치해있고 오른쪽 부모는 자기와 같은 j값에 위치
					triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]); //왼쪽 부모랑 오른쪽 부모중에 더했을 때 더 큰 값
				} else { //제일 왼쪽 대각선 계산
					triangle[i][j] += triangle[i-1][0];
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<N; i++) { //제일 마지막값을 돌면서 가장 큰 값 구하기
			max = Math.max(triangle[N-1][i], max);
		}
		
//		for(int[] i:triangle) {
//			for(int j: i) {
//				System.out.print(j);
//			}
//			System.out.println();
//		}
		
		System.out.println(max);
		
	} //main

}