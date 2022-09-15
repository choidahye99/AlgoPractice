import java.util.Scanner;

public class Main {
	//누적합 풀이
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int H = sc.nextInt();
		
		int[] down = new int[H+2];
		int[] up = new int[H+2];
		
		for(int i=1; i<=(N)/2; i++) {
			int a = sc.nextInt();
			int b = H - sc.nextInt() +1;
			down[a]++;
			up[b]++;
		}
		
		for(int i=1; i<=H; i++) {
			down[i] += down[i-1];
		}
		
		for(int i=H; i>=1; i--) {
			up[i] += up[i+1];
		}
		
		int min = N;
		int cnt = 0;
		for(int i=1; i<H+1; i++) {
			int dif = (down[H]-down[i-1])+(up[1]-up[i+1]);
			
			if(dif<min) {
				min = dif;
				cnt = 1;
			} else if(dif==min) cnt++;
		}
		System.out.println(min+" "+cnt);
	}

}
