import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] Mrr;
	static int[] Nrr;
	static boolean[] check;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Nrr = new int[N];
		
		M = sc.nextInt();
		Mrr = new int[M];

		for(int i=0; i<N; i++) {
			Nrr[i] = sc.nextInt();
		}
		
		sb = new StringBuilder();
		check = new boolean[N];
		Arrays.sort(Nrr);
		sequence(0);
		
		System.out.println(sb);
	
	}

	private static void sequence(int idx) {
		//탈출조건
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(Mrr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			
			if(!check[i]) {
				Mrr[idx] = Nrr[i];
				check[i] = true;
				sequence(idx+1);
				
				check[i] = false;
			}
		}
		
	}
}