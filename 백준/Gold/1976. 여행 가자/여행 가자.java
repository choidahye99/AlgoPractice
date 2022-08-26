


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		
		
		for(int i=0; i<=N; i++) {
			parent[i] = i;
				
		}
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n==1) merge(i,j);
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int pre = Integer.parseInt(st.nextToken());
		int cur = pre;
		boolean isPossible = true;
		for(int m=0; m<M-1; m++) {
			pre = cur;
			cur = Integer.parseInt(st.nextToken());
			if(!isUnion(pre,cur)) {
				isPossible = false;
				break;
			}
		}
		
		if(isPossible) System.out.println("YES");
		else System.out.println("NO");
	}
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void merge(int x, int y) {
		x =find(x);
		y = find(y);
		if(x == y) return;
		parent[y] = x;
	}
	
	static boolean isUnion(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return true;
		return false;
	}
}
