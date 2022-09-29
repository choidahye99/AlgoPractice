import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	static int[] p; // 대표자 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 창용마을 사람 수 //정점
			int M = sc.nextInt(); // 서로를 알고 있는 사람의 관계 수 //간선

			// 간선의 배열을 저장해봅시다
			int[][] edges = new int[M][2];

			for (int i = 0; i < M; i++) {
				edges[i][0] = sc.nextInt(); // 시작정점
				edges[i][1] = sc.nextInt(); // 도착정점
			}
			
			Arrays.sort(edges, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0]; //시작 정점 기준 오름차순 정렬
				}
				
			});

			p = new int[N + 1];

			for (int i = 1; i < N + 1; i++) {
				makeSet(i);
			}

			for (int i = 0; i < M; i++) {

				// i번째 두 정점의 대표를 확인한다
				int px = findSet(edges[i][0]); // 시작정점
				int py = findSet(edges[i][1]); // 끝정점

				// 연결된 정점인데 대표가 다르다면
				if (px != py) {
					union(px, py); // 대표 바꿔!!
				}
			}
			
//			System.out.println(Arrays.toString(p));

			// 몇개의 무리가 있는지
			ArrayList<Integer> list = new ArrayList<>();
			
			while(N>0) {
				
				if(list.size()==0) list.add(findSet(N));
				else {
					int check = 0; //중복체크
					for(int i=0; i<list.size(); i++) {
						if(findSet(N) == list.get(i)) check++;
					}
					
					if(check==0) list.add(findSet(N));
				}
				
				N--;
			}
			
//			System.out.println(list.toString());
			int ans = list.size();
			System.out.println("#"+tc+" "+ans);
			
		}//testCase
	} //main

	private static void union(int px, int py) {
		p[findSet(py)] = findSet(px); // py의 대표를 px의 대표로 바꾸삼
	}

	private static int findSet(int x) {

		if (x == p[x])
			return x;
		return findSet(p[x]);

	}

	private static void makeSet(int x) {
		// 자기자신으로 대표 초기화
		p[x] = x;
	}
}