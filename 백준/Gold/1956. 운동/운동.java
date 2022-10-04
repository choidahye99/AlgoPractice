import java.util.Scanner;

public class Main {
	static final int INF = 987654321;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); //마을의 개수
		int E = sc.nextInt(); //도로의 개수
		
		int[][] dist = new int[V+1][V+1];


		//참고
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(i != j)
					dist[i][j] = INF;
			}
		}
		
		for(int i=0; i<E; i++) {
			int st = sc.nextInt(); //시작마을
			int ed = sc.nextInt(); //도착마을
			int cost = sc.nextInt(); //비용
			
			 dist[st][ed] = cost; //일방통행입니당
		}
		
		
		//플로이드
		for(int k=1; k<=V; k++) { //경유지
			for(int i=1; i<=V; i++) { //출발
				for(int j=1; j<=V; j++) { //도착
					if(dist[i][j] > dist[i][k] + dist[k][j]) { //경유지를 거치는 비용이 더 작으면
						dist[i][j] = dist[i][k] + dist[k][j]; //갱신
					}
				}
			}
		}
		
		int ans = INF; //정답
		
		//(참고) 사이클이 돈다는 건 
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(i == j) continue; //자기 자신을 제외한 두 정점이 
				
				//서로에게 가는 경로가 있다는 것
				if(dist[i][j] != INF && dist[j][i] != INF) {
					ans = Math.min(ans, dist[i][j]+dist[j][i]);
				}
			}
		}
		
		if(ans >= INF) ans = -1;
		
		System.out.println(ans);
	}

}