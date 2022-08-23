

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String num = sc.next();

			char[] arr1 = new char[num.length()];
			for (int i = 0; i < num.length(); i++) {
				arr1[i] = num.charAt(i);
			}

			String zero = "";
			for (int i = 0; i < num.length(); i++) {
				zero += "0";
			}

			char[] arr2 = new char[zero.length()];
			for (int i = 0; i < zero.length(); i++) {
				arr2[i] = zero.charAt(i);
			}

			int size = arr1.length;

			int cnt = 0;
			for (int i = 0; i < size; i++) {
				if (arr1[i] == '0' && arr2[i] == '1') {
					int k = i;
					while (k < size) {
						arr2[k] = '0';
						k++;
					}
					cnt++;
				} else if (arr1[i] == '1' && arr2[i] == '0') {
					int k = i;
					while (k < size) {
						arr2[k] = '1';
						k++;
					}
					cnt++;
				}

			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
