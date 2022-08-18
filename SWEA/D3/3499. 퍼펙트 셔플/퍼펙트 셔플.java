import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 입력 받을 문자 수

			String[] shuffle = new String[N]; // 섞인 덱

			if (N % 2 == 0) { // 짝수 개의 카드 입력받을 경우
				String[] one = new String[N / 2]; // 첫번째로 나눈 덱의 카드들
				String[] two = new String[N / 2]; // 두번째로 나눈 덱의 카드들

				int cnt = 0;
				for (int i = 0; i < N; i++) {
					if (i < N / 2) {
						one[cnt++] = sc.next();
					} else {
						if (cnt >= N / 2)
							cnt = 0; // cnt 밖에서 관리하고 있으니까 초기화 해줘야 함

						two[cnt++] = sc.next();
					}
				} // 덱을 나눠봅시다

				for (int i = 0; i < N; i++) { // 섞어볼게요
					if (i % 2 == 0) {
						shuffle[i] = one[i / 2]; // 셔플 인덱스의 0,2,4,8,... 짝수번째 와야겠죵
					} else {
						shuffle[i] = two[i / 2]; // 셔플 인덱스의 1,3,5,7... 홀수번째 와야겠죵
					}
				}

				System.out.print("#" + tc + " ");
				for (String i : shuffle) {
					System.out.print(i + " ");
				}
				System.out.println();

			} else { // 홀수개의 카드를 입력받을 경우
				String[] one = new String[N / 2 + 1]; // 이 덱에서 먼저 놓을 거니까 한 개 더 받을 거예용
				String[] two = new String[N / 2];

				int oneCnt = 0;
				int twoCnt = 0; // 이번엔 인덱스를 따로 관리해봅시다
				for (int i = 0; i < N; i++) {
					if (i < N / 2 + 1) {
						one[oneCnt++] = sc.next();
					} else {
						two[twoCnt++] = sc.next();
					}
				}

				for (int i = 0; i < N; i++) { // 섞어볼게용
					if (i % 2 == 0) {
						shuffle[i] = one[i / 2];
					} else {
						shuffle[i] = two[i / 2];
					}
				}

				System.out.print("#" + tc + " ");
				for (String i : shuffle) {
					System.out.print(i + " ");
				}
				System.out.println();
			}

		}

	} // main

}