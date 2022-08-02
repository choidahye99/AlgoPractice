import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {

			int H = sc.nextInt();
			int W = sc.nextInt();
			int P = sc.nextInt();
			int N = H * W;

			int[] num = new int[N];
			
			int k=0;
			for(int i=0; i<W; i++) {
				for(int j=0; j<H; j++) {
					num[k] = (i+1)+(j+1)*100;
					k++;
				}
			}
		
			System.out.println(num[P-1]);
		}
	}
}
