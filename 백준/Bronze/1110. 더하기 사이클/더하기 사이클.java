import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		if (N < 10) {
			N = N * 10;
		}

		int cnt = 0;

		int t = N / 10;
		int o = N % 10;
		int sum = t + o;

		int a = sum % 10;

		int result = o * 10 + a;
		cnt++;
		
		
		for(;;) {
			if(result != N) {
				int t1 = result / 10;
				int o1 = result % 10;
				int sum1 = t1 + o1;

				int a1 = sum1 % 10;

				result = o1 * 10 + a1;
				cnt++;
			} else break;
		}

		System.out.println(cnt);
	}
}