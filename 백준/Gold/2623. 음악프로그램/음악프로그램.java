import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //가수의 수
		int M = sc.nextInt(); //보조PD의수
		
		List<Integer> adj[] = new ArrayList[N];
		for(int i=0; i<N; i++) adj[i] = new ArrayList<>();
		
		int[] inDg = new int[N];
		
		for(int i=0; i<M; i++) {
			int S = sc.nextInt(); //보조피디가 담당한 가수의 수
			int[] singer = new int[S];
			
			for(int j=0; j<S; j++) {
				singer[j] = sc.nextInt();
			} //가수 입력받기
			
//			System.out.println(Arrays.toString(singer));
			for(int j=0; j<S-1; j++) { //리스트에 연결하기 위해 가수배열을 돌아봅시다
				int st = singer[j]-1; //인덱스에 맞게 -1씩 해주기
				int ed = singer[j+1]-1;
				
				adj[st].add(ed); //인접리스트로 연결
				inDg[ed]++; //정점에 간선 연결됐다고 체크
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			if(inDg[i] == 0) q.add(i);
		}
		
		int[] musicShow = new int[N];
		int idx = 0;
		while(!q.isEmpty()) { //q가 빌 때까지 돌자
			int singer = q.poll(); // 가수 빼기
			musicShow[idx++] = singer; //출연자리스트에 가수 담기
			
			for(int i=0; i<adj[singer].size(); i++) { //연결돼있는 리스트만큼 돌기
				int num = adj[singer].get(i);
				inDg[num]--;
				
				if(inDg[num] == 0) q.add(num);
				
			}
		}
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			if(inDg[i]==0) cnt++;
		}
		
		if(cnt == N) {
			for(int i=0; i<N; i++) {
				System.out.println(musicShow[i]+1);
			}
		} else {
			System.out.println(0);
		}
		
	} //main

}