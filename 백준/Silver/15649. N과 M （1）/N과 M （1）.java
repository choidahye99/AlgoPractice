import java.util.Scanner;

public class Main {
	static int N; //1~N까지의 자연수
	static int M; //수열의 길이
	static int[] Nrr;
	static boolean[] check;
	static int[] Mrr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		Nrr = new int[N];
		for(int i=0; i<N; i++) {
			Nrr[i] = i+1;
		}
		
		Mrr = new int[M];
		check = new boolean[N];
		
		sequence(0);
		
	}
	
	public static void sequence(int idx) {
		//탈출 조건
		if(idx == M) {
			for(int i=0; i<M; i++) {
			System.out.print(Mrr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			//사용 안 했다면
			if(!check[i]) {
				
				Mrr[idx] = Nrr[i]; //사용하고
				check[i] = true; //사용했다고 바꿔주고
				sequence(idx+1); //다음으로
				
				check[i] = false; //또 써야되니까 다시 사용할 수 있게
			
			}
		}
	}

}