



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;






public class Main {
	static int[] parent = new int[200000];
	static int[] setNum = new int[200000];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			
			
			for(int i=0; i<200000; i++) {
				parent[i] = i;
				setNum[i] = 1;
			}
			int N = sc.nextInt();
		Map<String, Integer> map = new HashMap<>();
		int count = 0;
		for(int i=0; i<N; i++) {
			String f1 = sc.next(),f2 = sc.next();
			if(map.get(f1) == null) {
				map.put(f1, count);
				count++;
			}
			if(map.get(f2) == null) {
				map.put(f2,count);
				count++;
			}
			
			int friendNum = merge(map.get(f1), map.get(f2));
			System.out.println(friendNum);
		}
			
		}
		
		
	}
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static int merge(int x, int y) {
		x =find(x);
		y = find(y);
		if(x == y) return setNum[x];
		setNum[x] += setNum[y];
		setNum[y] = 0;
		parent[y] = x;
		return setNum[x];
	}
	
	static boolean isUnion(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return true;
		return false;
	}
}
