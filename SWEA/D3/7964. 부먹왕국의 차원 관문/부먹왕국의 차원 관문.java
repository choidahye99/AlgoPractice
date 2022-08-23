import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 도시수
			int D = sc.nextInt(); // 이동 제한 거리

			int[] door = new int[N + 2]; // 0번째랑 N+1번째도 차원관문이 있어용
			
			for (int i = 1; i < N + 1; i++) {
				door[i] = sc.nextInt();
			} // 도시별 차원관문 현황 입력

			int cnt = 0; // 차원관문 몇개 건설해야 하는지
			
			door[0] = 1;
			door[N+1] = 1;
			
			int i = 0; // 첫번째 문부터~
			while (i < N + 1) { // 마지막 도시까지 도는 동안
				if (door[i] == 0) { // 차원관문이 없으면
					door[i] = 1; // 하나 설치해주공
					cnt++; // 차원관문 하나 설치했다~ cnt 증가
					for(int j=1; j<=D; j++) {
						if(door[i+j]==1){
							i = i+j;
							break;
						} else {
							if(i+j == i+D) {
								i = i+D;
							}
							continue;
						}
					}
				} else {
					for(int j=1; j<=D; j++) {
						if(door[i+j]==1){
							i = i+j;
							break;
						} else {
							if(i+j == i+D) {
								i = i+D;
							}
							continue;
						}
					}
				}
			}

			System.out.println("#" + tc + " " + cnt);
		}

	}
}