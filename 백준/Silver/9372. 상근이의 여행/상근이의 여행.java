import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] airPlane; // i부터 j까지 왕복하는지 표시.
	static boolean[] visited; // 이미 출발국이었던 나라인지 아닌지. 큐 추가땜시
	static int N, M, travel; // 방문해야 할 국가 수, 주어질 비행기 스케줄, 국가 도달 횟수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스

		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			travel = 0;

			airPlane = new int[N + 1][N + 1]; // 1부터 시작해서 배열 한 개씩 크게
			visited = new boolean[N + 1];

			for (int i = 0; i < M; i++) {
				int a = sc.nextInt(); // 출발 국가
				int b = sc.nextInt(); // 도착 국가

				airPlane[a][b] = 1; // 이동 가능
				airPlane[b][a] = 1; // 왕복

			}
			
			//여기서부터 탐색

			visited[1] = true; // 1번 국가부터 탐색하니까 무조건 방문

			Queue<Integer> que = new LinkedList<>(); // 탐색 국가 담을 큐
			que.add(1); // 1번 국가부터 탐색합시당

			while (!que.isEmpty()) { // 탐색 국가가 더 이상 없을 때까지 반복
				travel++; // 나라를 방문했죵

				int start = que.poll();
				for (int i = 1; i <= N; i++) { // 도착 국가 다 돌아볼게여
					if (airPlane[start][i] != 0 && !visited[i]) { // 여행가능한 국가여야되고 출발국가 아니었던 곳이어야 함
						visited[i] = true; // 이 루트는 방문했다네~ 남겨주고
						que.add(i); // 시작국가로 추가
					}
				}

			}

			System.out.println(travel - 1); // 비행기 이용횟수는 여행국가 -1
			
		}// testCase
	}// main
}