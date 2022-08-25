
import java.util.Scanner;

public class Main {

	static int map[][];
	static int dp[][];
	static int n, visited;
	static int INF = Integer.MAX_VALUE - 1000000;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n =  sc.nextInt();
		map = new int[n][n];
		dp = new int[n][1<<n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//  0에서 출발해서 순회 
		System.out.println(tsp(0,1));

	}

	
	 static int tsp(int current, int visited) {
		 if((visited == (1<<n)-1)) {
			 //  마지막 도시에서 0번도시로 돌아갈 수 없으면
			  if(map[current][0] == 0) {
				  return INF;
			  }
			  
			  return map[current][0];
		 }
		 // 이미 방문한 적이 있다. 
		 if(dp[current][visited] != 0 ) {
			 return dp[current][visited];
		 }
		 
		 //  최소값을 구하기 위한 과정
		 dp[current][visited] = INF;
		 for(int k=0; k<n; k++) {
			 int next = 1<<k;
			 //방문할 수 업거나, 방문했다면 건너뜀
			 if(map[current][k] == 0 || (visited & next) >0) {
				 
				 continue;
			 }
			 // 최소비용 구하기 ㄱㄱ
			 dp[current][visited] = Math.min(dp[current][visited], tsp(k, visited | next)+ map[current][k]);
			 
		 }
		 return dp[current][visited];
	 }
}
