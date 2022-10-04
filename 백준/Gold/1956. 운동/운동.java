import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 987654321;
	static int[][] town;
	static int V, E, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 마을 개수
		E = Integer.parseInt(st.nextToken()); // 간선

		result = INF;
		town = new int[V + 1][V + 1];

		// 초기 설정
		for (int i = 1; i <= V; i++) {
			Arrays.fill(town[i], INF);
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			// 중복되는 간선이 없다 했으므로
			town[start][end] = len;
		}

		findLoad();
		result = result == INF ? -1 : result;
		System.out.println(result);
	}// main

	private static void findLoad() {

		// 우선 각 사이클이 아닌 각 도착지 까지 가는 거리 구하기
		// 경유
		for (int i = 1; i <= V; i++) {
			// 출발
			for (int j = 1; j <= V; j++) {
				// 도착
				for (int k = 1; k <= V; k++) {
					// 기존 값보다 경유하고 왔을 경우가 짧으면 갱신
					if (town[j][k] > town[j][i] + town[i][k]) {
						town[j][k] = town[j][i] + town[i][k];
					}
				}
			}
		}

		// 사이클 중 최솟값 구하기
		for (int i = 1; i <= V; i++) {
			result = Math.min(result, town[i][i]);
		}
	}// findLoad
}