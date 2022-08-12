import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int a0 = 1,a1 = 0,b0 = 0, b1=1;
			for(int i=0; i<N-1; i++) {
				int atemp = a0+a1;
				int btemp = b0+b1;
				a0 = a1;
				b0 = b1;
				a1 = atemp;
				b1 = btemp;
			}
			
			if(N == 0) System.out.println(a0+" "+b0);
			else {
				System.out.println(a1+" "+b1);
			}
			
		}
	}

}