import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static class Node { //과목과 학기를 묶어서 가지고 다닐 거예용
		int subject, semester;

		public Node(int subject, int semester) {
			super();
			this.subject = subject;
			this.semester = semester;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //과목의 수
		int M = sc.nextInt(); //선수조건의 수
		
		List<Integer>[] adj = new ArrayList[N];
		for(int i=0; i<N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		int[] inDg = new int[N];
		
		// 인접리스트, 인디그리 배열 초기화 완료
		
		for(int i=0; i<M; i++) {
			int st = sc.nextInt()-1;
			int ed = sc.nextInt()-1;
			
			adj[st].add(ed);
			inDg[ed]++;
		}
		
		Queue<Node> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			if(inDg[i] == 0) q.add(new Node(i, 1));
		} //시작점이면 1학기에 듣는 거!
		
		int[] smst = new int[N];
		while(!q.isEmpty()) { //큐가 빌 때까지 돌아봅시다
			Node sub = q.poll();
			smst[sub.subject] = sub.semester;
			
			for(int i=0; i<adj[sub.subject].size(); i++) { //지금 꺼낸 과목과 연결된 과목 다 돌거야
				int subj = adj[sub.subject].get(i);
				inDg[subj]--;
				
				if(inDg[subj] == 0) {
					q.add(new Node(subj, sub.semester+1));
				}
			}
			
		}
		
		for(int i=0; i<N; i++)
			System.out.print(smst[i]+" ");
		
	}

}