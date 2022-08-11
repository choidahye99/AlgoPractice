import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트케이스 개수
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); //퍼즐 배열 범위
			int K = sc.nextInt(); //단어길이
			
			int[][] puzzle = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			} //퍼즐 모양 입력
			
			int word = 0; //단어가 들어갈 수 있는 자리 개수
			
			//행 탐색
			for(int i=0; i<N; i++) {
				int cnt = 0; // 행 바뀔때마다 초기화
				for(int j=0; j<N; j++) {
					if(puzzle[i][j]==0) {
						if(cnt==K) { //벽을 만나기 전에 K만큼의 공간이 확보되어 있으면
							word++; //단어를 넣을 수 있는 자리로 판단하여 +1
						}
						cnt=0; //벽을 만났으니 cnt초기화
						continue;
					} else {
						cnt++;
					}
					
				}
				if(cnt == K) { //빈칸의 개수가 K와 같으면
					word++; //단어를 넣을 수 있는 자리로 판단하여 +1
				}
			}
			
			//열 탐색
			for(int j=0; j<N; j++) {
				int cnt = 0;
				for(int i=0; i<N; i++) {
					if(puzzle[i][j]==0) {
						if(cnt==K) {
							word++;
						}
						cnt = 0;
						continue;
					} else {
						cnt++;
					}
				}
				if(cnt==K) {
					word++;
				}
			}
			
			System.out.println("#"+tc+" "+word);
		}
	}

}
