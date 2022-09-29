import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static class Position {
		int x, y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 섬의 개수 //정점
			int Ed = (N) * (N - 1) / 2; // 해저터널의 개수 //간선

			int[] x = new int[N]; // x좌표
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
			}

			int[] y = new int[N]; // y좌표
			for (int i = 0; i < N; i++) {
				y[i] = sc.nextInt();
			}

			double E = sc.nextDouble(); // 환경부담금
			
			ArrayList<Position> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(new Position(x[i], y[i]));
			} // 좌표 추가

			double[][] edge = new double[Ed][3];

				int idx = 0;
				for (int j = 0; j < list.size(); j++) {
					for (int k = j + 1; k < list.size(); k++) {
						edge[idx][0] = j; // 시작정점
						edge[idx][1] = k; // 끝정점
						// 가중치
						edge[idx][2] = (Math.pow(Math.abs(list.get(j).x - list.get(k).x), 2)
								+ Math.pow(Math.abs(list.get(j).y - list.get(k).y), 2)) * E;
						idx++;
					}
				}
			
			
			Arrays.sort(edge, new Comparator<double[]>() {

				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}
				
			});

//				System.out.println(Arrays.deepToString(edge));
			
			p = new int[N];
			
			for(int i=0; i<N; i++) {
				makeSet(i);
			}
			
			double ans = 0;
			
			int peek = 0; //내가 간선 몇개 뽑았는지
			for(int i=0; i<Ed; i++) {
				int px = findSet((int) edge[i][0]); //시작정점
				int py = findSet((int) edge[i][1]); //끝 정점
				
				if(px != py) { //대표자가 다르면
//					System.out.println(Arrays.toString(edge[i]));
					union(px, py);
					ans += edge[i][2];
					peek++;
				}
			
				if(peek == N-1) break;
			}
			
			System.out.println("#"+tc+" "+Math.round(ans));
		}
	}
	

	private static void union(int px, int py) {
		
		p[findSet(py)] = findSet(px);
		
	}

	private static int findSet(int idx) {
		
		if(p[idx] != idx) p[idx] = findSet(p[idx]);
		return p[idx];
	}

	private static void makeSet(int x) {
		p[x] = x;
	}

}
