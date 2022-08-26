
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N + 1];
		ArrayList<Integer>[] tree = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int small = sc.nextInt();
			int tall = sc.nextInt();
			tree[tall].add(small);
			arr[small]++;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i =1; i<=N; i++) {
			if(arr[i] == 0) {
			
				q.add(i);
				
			}
		}
		
		while(true) {
			
			// 큐에 맨 앞에 것을 꺼내서, 연결된 값들에 대해 진입차수를 1개씩 마이너스 해주고, 0이 되면, 큐에 넣어준다. 
			for(int i=0; i<tree[q.peek()].size(); i++) {
				int linkedNode = tree[q.peek()].get(i);
				arr[linkedNode]--;
				if(arr[linkedNode] == 0) q.add(linkedNode);
				
			}
			stack.add (q.poll());
			
			if(stack.size() == N) break;
		}
		
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
}
