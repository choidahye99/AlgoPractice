
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList[] arr;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		 arr = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<ArrayList>();
		}
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			
			
			while(true) {
				ArrayList<Integer> list = new ArrayList<>();
				int end = Integer.parseInt(st.nextToken());
				if(end == -1) break;
				int dis = Integer.parseInt(st.nextToken());
				list.add(end);
				list.add(dis);
				arr[start].add(list);
				
			}
			
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		int[] sum = new int[N+1];
		
		q.add(1);
		boolean isVisited[] = new boolean[N+1];
		isVisited[1] = true;
		int max = 0;
		int idx = 0;
		while(!q.isEmpty()) {
			for(int i=0; i<arr[q.peek()].size(); i++) {
				
				int newNode = (int) ((ArrayList) arr[q.peek()].get(i)).get(0);
				int newDis = (int) ((ArrayList) arr[q.peek()].get(i)).get(1);
				if(!isVisited[newNode]) {
					q.add(newNode);
					sum[newNode] = sum[q.peek()]+newDis;
					if(max <sum[newNode]) {
						max = sum[newNode];
						idx = newNode;
					}
					isVisited[newNode] = true;
				}
				
			}
			q.poll();
		}
		
		
		
		// idx 기준으로 다시 한번 
		q.clear();
		sum = new int[N+1];
		q.add(idx);
		isVisited = new boolean[N+1];
		isVisited[idx] = true;
		
		while(!q.isEmpty()) {
			for(int i=0; i<arr[q.peek()].size(); i++) {
				
				int newNode = (int) ((ArrayList) arr[q.peek()].get(i)).get(0);
				int newDis = (int) ((ArrayList) arr[q.peek()].get(i)).get(1);
				if(!isVisited[newNode]) {
					q.add(newNode);
					sum[newNode] = sum[q.peek()]+newDis;
					if(max <sum[newNode]) {
						max = sum[newNode];
						idx = newNode;
					}
					isVisited[newNode] = true;
				}
				
			}
			q.poll();
		}
		System.out.println(max);
	}
	
	
}
