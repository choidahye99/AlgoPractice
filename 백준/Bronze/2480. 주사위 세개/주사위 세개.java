import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int one = sc.nextInt();
		int two = sc.nextInt();
		int thr = sc.nextInt();
		
		
		if(one==two&&two==thr) {
			int money = 10000 + one*1000;
			System.out.println(money);
		} else if(one == two && two!=thr) {
			int money = 1000 + one*100;
			System.out.println(money);
		} else if(one == thr && two!=thr) {
			int money = 1000 + one*100;
			System.out.println(money);
		} else if(two == thr && two!=one) {
			int money = 1000 + two*100;
			System.out.println(money);
		} else if (one != two && two != thr && one != thr) {
		
			int max1 = Math.max(one, two);
			int max = Math.max(thr, max1);
			
			int money = max*100;
			System.out.println(money);
		}
		
		
	}
	
}