import java.util.Scanner;

public class Main {
	//조합을 구하는 문제인가 봅니다
	static int N; // 1~N까지 숫자
	static int M; // 수열의 길이
	static int[] Nrr;
	static boolean[] check;
	static int[] Mrr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Nrr = new int[N];
		for(int i=0; i<N; i++) {
			Nrr[i] = i+1;
		}
		M = sc.nextInt();
		Mrr = new int[M];
		
		check = new boolean[N];
		sequence(0);
	}

	private static void sequence(int idx) {
		//탈출 조건
		if(idx == M) {
			for(int i=0; i<M-1; i++) {
				if(Mrr[i]>Mrr[i+1]) return;
			}
			
			for(int i=0; i<M; i++) {
				System.out.print(Mrr[i]+" ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if(!check[i]) {
				Mrr[idx] = Nrr[i];
				check[i] = true;
				sequence(idx+1);
				
				check[i] = false;
			}
		}
		
		
	}
	

}