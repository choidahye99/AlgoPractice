import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] Mrr;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		M = sc.nextInt();
		Mrr = new int[M];
		
		sb = new StringBuilder();
		sequence(0);
	
		System.out.println(sb);
	}

	static void sequence(int idx) {
		
		//탈출조건
		if(idx == M) {
			for(int i=0; i<M-1; i++) {
				if(Mrr[i]>Mrr[i+1]) return;
			}
			
			for(int i=0; i<M; i++) {
				sb.append(Mrr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			Mrr[idx] = i;
			sequence(idx+1);
		}
	}

}