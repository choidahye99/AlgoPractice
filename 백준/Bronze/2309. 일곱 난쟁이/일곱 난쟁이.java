import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] kids;
	static boolean[] check;
	static int[] realKids;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		kids = new int[9];
		check = new boolean[9];
		realKids = new int[7];

		for (int i = 0; i < kids.length; i++) {
			kids[i] = sc.nextInt();
		}
		
		findKid(0);

		Arrays.sort(realKids);
		for(int i:realKids)
		System.out.println(i);
	}

	public static void findKid(int idx) {
		// 기저조건
		if (idx == kids.length) {
			int cnt = 0;
			for (int i = 0; i < check.length; i++) {
				if (check[i]) cnt++;
			}

			if (cnt == 7) {
				int sum = 0;
				for (int i = 0; i < kids.length; i++) {
					if (check[i]) sum += kids[i];
				}
				
				if (sum == 100) {
					int j = 0;
					while (j < 7) {
						for (int i = 0; i < kids.length; i++) {
							if (check[i]) {
								realKids[j++]=kids[i];
							}
						}
					}
				}
			}
			return;
		}

		// 체크
		check[idx] = true;
		findKid(idx + 1);
		check[idx] = false;
		findKid(idx + 1);
	}
}
