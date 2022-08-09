
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int dump = sc.nextInt(); // 덤프 횟수
			int[] highs = new int[100];

			for (int i = 0; i < 100; i++) {
				highs[i] = sc.nextInt();
			}
			int result = 0;
			while (dump >= 0) {
				int max = 0;
				int min = 100;

				for (int i : highs) {
					max = Math.max(max, i);
					min = Math.min(min, i);
				}

				for (int i = 0; i < 100; i++) {
					if (highs[i] == max) {
						highs[i] -= 1;
						break;
					}
				}

				for (int i = 0; i < 100; i++) {
					if (highs[i] == min) {
						highs[i] += 1;
						break;
					}
				}

				result = max - min;

				if (max - min <= 1) {
					System.out.println(max - min);
					break;
				}

				dump--;
			}
			System.out.printf("#%d %d\n", tc, result);
		}
	}

}
