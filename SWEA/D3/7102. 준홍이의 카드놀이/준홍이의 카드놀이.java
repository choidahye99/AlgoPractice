import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 첫번째 카드세트
			int[] cardA = new int[N];
			for (int i = 0; i < N; i++) {
				cardA[i] = i + 1;
			}

			int M = sc.nextInt(); // 두번째 카드세트
			int[] cardB = new int[M];
			for (int i = 0; i < M; i++) {
				cardB[i] = i + 1;
			}

			int[] addCard = new int[N + M + 1]; // 더한 값을 index로 받는 배열

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					addCard[cardA[i] + cardB[j]]++; //더한값을 카운트하기
				}
			}

			List<Integer> list = new ArrayList<>();

			int max = 0;
			for (int i = 0; i < addCard.length; i++) {
				max = Math.max(addCard[i], max); //제일 빈번하게 나온 합 = addCard배열에서 제일 큰 값을 가지고 있는 인덱스
			}

			for (int i = 1; i < addCard.length; i++) {
				if (max == addCard[i]) {
					list.add(i); //제일 많이 나온 합을 추가추가
				}
			}

			//출력
			System.out.print("#" + tc + " ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();

		} // testCase
	} // main

}