import java.util.Scanner;

public class Solution {
	static int N; // 고객의 수
	static int[] xrr; // 초기 x값 배열
	static int[] yrr; // 초기 y값 배열
	static int[] resultX; // 결과 배열
	static int[] resultY;
	static int ans; // 최소거리
	static boolean[] check; // 방문 했는지 아닌지

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			xrr = new int[N+2];
			yrr = new int[N+2];
			
			for(int i=0; i<N+2; i++) {
				xrr[i] = sc.nextInt();
				yrr[i] = sc.nextInt();
			} //좌표 채우기
						
			resultX = new int[N+2];
			resultY = new int[N+2];
			
			resultX[0] = xrr[0]; //첫번째는 무조건 회사 고정
			resultY[0] = yrr[0];
			
			resultX[xrr.length-1] = xrr[1]; //마지막은 집 고정
			resultY[yrr.length-1] = yrr[1];
			
			check = new boolean[N];
			
			ans = Integer.MAX_VALUE;
			
			shortest(1);
			
			System.out.println("#"+tc+" "+ans);
			
		} //테스트케이스

	} //main
	
	public static void shortest(int idx) {
		
		//탈출조건
		if(idx == xrr.length-1) {
			
			int X = 0;
			
			for(int i=0; i<N+1; i++) {
				X += Math.abs(resultX[i] - resultX[i+1]) + Math.abs(resultY[i] - resultY[i+1]); //거리의 합
				
				if(X>ans) return; //계산하다가 거리의 합이 현재 나와있는 거리의 최소값보다 커지면 계산 종료
			}
			
			ans = Math.min(ans, X); //최소값 갱신

			return;
		}
		
		
		for(int i=2; i<N+2; i++) {
			if(!check[i-2]) { //아직 안 간 집이다
				resultX[idx] = xrr[i];
				resultY[idx] = yrr[i];
				
				check[i-2] = true; //갔다고 바꿔주고
				shortest(idx+1); //내려가기
				
				check[i-2] = false; //다음에 다시 가야 되니까 초기화
				
			}
		}
	}

}