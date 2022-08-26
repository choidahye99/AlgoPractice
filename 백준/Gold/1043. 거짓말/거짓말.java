

import java.util.Scanner;

public class Main {
	static int parent[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		parent = new int[N+1];
		for(int i=0; i<=N; i++) {
			parent[i] = i;
		}
		// 아는 사람의 수 
		int know = sc.nextInt();
		int arr[] = new int[know];
		
		for(int i=0; i<know; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<know-1; i++) {
			merge(arr[i],arr[i+1]);
		}
		
		// 각 파티의 첫사람
		int firstArr[] = new int[M];
		for(int i=0; i<M; i++) {
			// 파티에 오는 사람 수 
			int partyNum = sc.nextInt();
			int[] partyArr = new int[partyNum];
			for(int j=0; j<partyNum; j++) {
				partyArr[j] = sc.nextInt();
			}
			firstArr[i] = partyArr[0];
			for(int j=0; j<partyNum-1; j++) {
				merge(partyArr[j],partyArr[j+1]);
			}
			
			
		}
		
		// 진실을 아는 자가 한명도 없으면 
		if(know == 0) System.out.println(M);
		else {
			int check = arr[0];
			int count =0;
			for(int i=0; i<M; i++) {
				if(!isUnion(check,firstArr[i])) {
					count++;
				}
			}
			
			System.out.println(count);
			
		}
		
	}

	static int find(int x) {
		if(parent[x] == x) return x;
			
		return parent[x] = find(parent[x]);
		
	}

	static void merge(int x, int y) {
		if(find(x) == find(y)) return;
		parent[find(y)] = find(x);
	}

	static boolean isUnion(int x, int y) {
		if(find(x) == find(y)) return true;
		return false;
	}
}
