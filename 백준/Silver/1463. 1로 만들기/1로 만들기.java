import java.util.Scanner;

public class Main {
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		toOne(n, 0);
		System.out.println(ans);
	

	}
	
	static void toOne(int n, int cnt) {
		
		if(n==1) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if(cnt >= ans) return;
		
		if(n%3==0) {
			toOne(n/3, cnt+1);
		}
		
		if(n%2==0) {
			toOne(n/2, cnt+1);
		}
		
		toOne(n-1, cnt+1);

	}
}
