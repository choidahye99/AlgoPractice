import java.util.Scanner;

public class Main {
	// 중복순열
	static int N;
	static int M;
	static int[] Nrr;
	static int[] Mrr;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Nrr = new int[N];
		for (int i = 0; i < N; i++) {
			Nrr[i] = i + 1;
		}

		M = sc.nextInt();
		Mrr = new int[M];

		sb = new StringBuilder();
		sequence(0);
		
		System.out.print(sb);
	}

	private static void sequence(int idx) {
		// 탈출조건
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(Mrr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i=0; i<N; i++) {
			Mrr[idx] = Nrr[i];
			sequence(idx+1);
		}

		
	}

}
