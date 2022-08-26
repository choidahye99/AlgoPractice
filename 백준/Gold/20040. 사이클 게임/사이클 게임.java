
import java.util.Scanner;

public class Main {
	static int parent[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		parent = new int[N];
		for(int i=0; i<N; i++) {
			parent[i] = i;
		}
		int cycleIndex = 0;
		for (int i = 1; i <= M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			if(isUnion(start,end)) {
				cycleIndex = i;
				break;
			}
			merge(start,end);
			
			
		}
		System.out.println(cycleIndex);
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void merge(int x, int y) {
		parent[find(y)] = find(x);
	}

	static boolean isUnion(int x, int y) {
		if (find(x) == find(y))
			return true;
		return false;
	}
}
