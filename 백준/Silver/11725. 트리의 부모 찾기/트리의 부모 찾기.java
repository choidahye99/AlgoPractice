
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		// 연결 (양방향) 넣어주기 
		for(int i=0; i<N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
			arr[b].add(a);
			
			
		}
		Queue<Integer> q = new LinkedList<Integer>();
		
		boolean isVisited[] = new boolean[N+1];
		
		int[] parentsArr = new int[N+1];
		
		q.add(1);
		isVisited[1] = true;
		while(!q.isEmpty()) {
			for(int i=0; i<arr[q.peek()].size(); i++) {
				if(!isVisited[arr[q.peek()].get(i)]) {
					isVisited[arr[q.peek()].get(i)] = true;
					q.add(arr[q.peek()].get(i));
					parentsArr[arr[q.peek()].get(i)] = q.peek();
				}
			}
			q.poll();
		}
		
		
		for(int i=2; i<N+1; i++) {
			System.out.println(parentsArr[i]);
		}
	}

}
