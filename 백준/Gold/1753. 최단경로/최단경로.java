

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//다다다다 다다ㅏ 다 다익스트라
public class Main {

	public static class Node {
		int v, cost;

		public Node(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", cost=" + cost + "]";
		}

	}

	static int V; // 정점
	static int E; // 간선
	static int K; // 시작점
	static List<Node>[] adjList;
	static int[] dist; // 비용 저장할 배열
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();

		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		dist = new int[V];
		Arrays.fill(dist, INF);

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int cost = sc.nextInt();

			adjList[st-1].add(new Node(ed-1, cost));
		}

		dikstra(K);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<V; i++) {
			if(dist[i] == INF) sb.append("INF").append("\n");
			else sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}

	private static void dikstra(int st) {

		boolean[] check = new boolean[V];

		dist[st-1] = 0;

		for (int i = 0; i < V; i++) {
			int min = INF;
			int idx = -1;

			for (int j = 0; j < V; j++) {
				if (!check[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
//					System.out.println("j: "+j);
				}
			} //연결된 것 중에 작은 값을 찾아
			
			if(idx == -1) continue; //연결된 게 없으면 멈춰
			
			check[idx] = true;
			
//			System.out.println("idx: "+idx);
//			System.out.println("idxsize: "+adjList[idx].size());
			//idx에 연결된 정점들을 갱신해봅시다
			for(int j=0; j<adjList[idx].size(); j++) {
				Node curr = adjList[idx].get(j); //idx와 연결된 j번째 노드
				
//				System.out.println(curr.toString());
				if(!check[curr.v] && dist[curr.v] > dist[idx] + curr.cost) {
					dist[curr.v] = dist[idx] + curr.cost;
				}
				
			}
			
		}

	}
}
