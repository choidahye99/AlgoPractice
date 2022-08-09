import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int cnt=0;
		
		if(B<C) {
			while((C-B)*cnt<=A) {
				cnt++;
			}
		} else {
			cnt = -1;
		}
		
		System.out.println(cnt);
	}
	

}