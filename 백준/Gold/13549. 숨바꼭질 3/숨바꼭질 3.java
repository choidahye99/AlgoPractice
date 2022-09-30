import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int N;// 수빈이의 현재 위치
	static int K; // 동생 위치
	static boolean[] check;
	static int[] dist; // 시작위치 -> K까지 가는 최단시간
	static int INF = Integer.MAX_VALUE;
	static int ans; // 최단위치

	public static class Node implements Comparable<Node> {

		int idx, cost;

		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 시작정점
		K = sc.nextInt(); // 도착정점

		dist = new int[100001];

		Arrays.fill(dist, INF);

		ans = 0;
		dikstra(N);

		System.out.println(ans);

	}

	private static void dikstra(int N) {

		PriorityQueue<Node> pq = new PriorityQueue<>();

		check = new boolean[100001];

		pq.add(new Node(N, 0)); //시작점
		dist[N] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (check[curr.idx])
				continue;

			if (curr.idx == K) {
				ans = dist[curr.idx];				
				return;
			}

			check[curr.idx] = true;
			dist[curr.idx] = curr.cost;
			

			// 2의 배수 처리
			if (curr.idx != 0) {
				for (int k = curr.idx * 2; k < (dist.length); k *= 2) {
					dist[k] = dist[curr.idx];
					pq.add(new Node(k, dist[k]));
				}
				
			}

			if ((curr.idx - 1) >= 0 && !check[curr.idx - 1] && dist[curr.idx - 1] > dist[curr.idx] + 1) {
				dist[curr.idx - 1] = dist[curr.idx] + 1;
				pq.add(new Node(curr.idx - 1, dist[curr.idx - 1]));
//				if ((curr.idx - 1) == K) {
//					ans = dist[curr.idx - 1];
//					return;
//				}
			}

			// idx+1 갱신
			if ((curr.idx + 1) < dist.length && !check[curr.idx + 1] && dist[curr.idx + 1] > dist[curr.idx] + 1) {
				dist[curr.idx + 1] = dist[curr.idx] + 1;
//				if ((curr.idx + 1) == K) {
//					ans = dist[curr.idx + 1];
//					return;
//				}
				pq.add(new Node(curr.idx + 1, dist[curr.idx + 1]));
			}


		}

	}// dikstra
}