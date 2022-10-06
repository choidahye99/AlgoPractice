import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //학생들의 수
		int M = sc.nextInt(); //키를 비교한 횟수
		int[] inDg = new int[N]; //in degree
		List<Integer>[] adj = new ArrayList[N]; //인접리스트
		
		for(int i=0; i<N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		//정점 연결하고 인디그리 ++
		for(int i=0; i<M; i++) {
			int prev = sc.nextInt()-1; //앞에 서야 하는 학생
			int next = sc.nextInt()-1; //뒤에 서야 하는 학생
			
			adj[prev].add(next);
			inDg[next]++;
		}
		
		//시작정점 다 큐에 담기
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			if(inDg[i] == 0) q.add(i);
		}
		
		//큐가 빌 때까지
		while(!q.isEmpty()) {
			int st = q.poll(); //학생 꺼내서
			System.out.print((st+1)+" "); //출력

			
			for(int i=0; i<adj[st].size(); i++) { //st에 연결돼 있는 거 다 돌자
				int nt = adj[st].get(i);
				inDg[nt]--; //연결돼있는 거 전입 하나 빼줘
				
				if(inDg[nt]==0) q.add(nt);
				
			}
		}
		
	} //main

}