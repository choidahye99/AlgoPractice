

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer NandM = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(NandM.nextToken());
		int M = Integer.parseInt(NandM.nextToken());
		
		parent = new int[N+1];
		
		
		for(int i=0; i<=N; i++) {
			parent[i] = i;
			
			
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int unionOrFind = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(unionOrFind == 0) {
				
					merge(start,end);
			
				
			}else {
				if(isUnion(start,end)) System.out.println("YES");
				else System.out.println("NO");
			}	
		}
		
		
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
