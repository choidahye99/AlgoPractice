
import java.util.Scanner;

public class Solution {
	static int N; //재료 개수
	static int[] Ns;
	static boolean[] check;
	static int food; //요리 하나당 쓰이는 재료 개수
	static int[] A; //A요리에 쓰는 재료
	static boolean[] checkA;
	static int[] a; //a 조합 결과 배열
	static int[] B; //B요리에 쓰는 재료
	static boolean[] checkB;
	static int[] b;
	static int[][] map; //시너지 
	static int resultA; //A요리 시너지 합
	static int resultB;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
		
		N = sc.nextInt(); //재료 수
		
		Ns = new int[N];
		for(int i=1; i<=N; i++) {
			Ns[i-1] = i;
		}
		
		check = new boolean[N];
		
		food = N/2; //각 요리에 들어갈 재료 수
		A = new int[food];
		checkA = new boolean[food];
		B = new int[food];
		checkB = new boolean[food];
		
		a = new int[2];
		b = new int[2];
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		makeFood(0, 0);
		
		System.out.println("#"+tc+" "+ans);
		
		}
	}

	private static void makeFood(int idx, int sidx) {
		//탈출조건
		if(sidx == food) {
//			System.out.println(Arrays.toString(check));
			int bdx = 0;
			int adx = 0;
			for(int i=0; i<N; i++) {
				if(!check[i]) {
					B[bdx++] = Ns[i];
				} else {
					A[adx++] = Ns[i];
				}
			}
			resultA = 0;
			resultB = 0;
//			System.out.println(Arrays.toString(A));
//			System.out.println(Arrays.toString(B));
			// A = [] B = [] 여기까지 만들었고
			
			combination(0);
			
			ans = Math.min(ans, Math.abs(resultA-resultB));
			 
			return;
		} else if(idx >= N) return;
		else {
		
//				A[sidx] = Ns[idx];
				makeFood(idx+1, sidx);
				check[idx] = true;
				makeFood(idx+1, sidx+1);
				check[idx] = false;
		}
	}

	//result를 만들어봅시다
	private static void combination(int idx) {
		//탈출조건
		if(idx > 1) {
//			System.out.println(map[a[0]-1][a[1]-1]);
//			System.out.println(map[b[0]-1][b[1]-1]);
				resultA += map[a[0]-1][a[1]-1];
				resultB += map[b[0]-1][b[1]-1];
//				System.out.println(b[0]-1);
//				System.out.println(b[1]-1);
				return;
		}
		
		for(int i=0; i<food; i++) {
			if(!(checkA[i])) {
				a[idx] = A[i];
				b[idx] = B[i];
				checkA[i] = true;
				checkB[i] = true;
				combination(idx+1);
				
				checkA[i] = false;
				checkB[i] = false;
			}
		}
	}

}
