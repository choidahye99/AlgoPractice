import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int D;
	static int W;
	static int K;
	static int[][] glass;
	static int[][] glass2;
	static boolean[] checkA;
	static boolean[] checkB;
	

	static List<Integer> list; // 바꿀
	static int ans; // 약품투입횟수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			D = sc.nextInt(); // 두께
			W = sc.nextInt(); // 넓이
			K = sc.nextInt(); // 통과기준
			glass = new int[D][W];

			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					glass[i][j] = sc.nextInt();
				}
			}

			// 열탐색으로 0이 3개거나 1이 연속되는지 확인
			if (search(glass)) { // 바로 통과하는 경우
				System.out.println("#" + tc +" " + 0);
			} else { // 약품 투입합시다

				ans = Integer.MAX_VALUE;

				// 차자보자아
				for (int i = 1; i < (1 << D); i++) {// 공집합 제외 D개의 원소로 만들 수 있는 부분집합
					list = new ArrayList<>();
					for (int j = 0; j < D; j++) {
						if ((i & (1 << j)) > 0)
							list.add(j); // 부분집합에 포함되는 원소 담기
					}

//				System.out.println(list.toString());

					int size = list.size();
//				System.out.println(size);
					// list =[바꿔야 할 줄의 인덱스가 담겨있음]
//				result = new int[size];
					// 중복순열로 라인 바꿔가면서 탐색
					checkA = new boolean[D];

					change(0, size, list);

//				System.out.println(i+" "+list.toString());
				}

				System.out.println("#" + tc +" " +ans);
			}
//		System.out.println(search(glass));
		}

	}

	private static void change(int idx, int size, List<Integer> arr) {
		// 탈출 조건
		if (size >= ans)
			return;

		if (idx == size) {
			glass2 = new int[D][W];

			checkB = new boolean[D];// B로 바꿀 라인 체크

			for (int i = 0; i < size; i++) {
				if (!checkA[list.get(i)]) {
					checkB[list.get(i)] = true;
				}
			}

//			System.out.println("A" + size + " " + Arrays.toString(checkA));
//			System.out.println("B" + size + " " + Arrays.toString(checkB));

			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					if (checkA[i]) {
						glass2[i][j] = 0;
					} else if (checkB[i]) {
						glass2[i][j] = 1;
					} else {
						glass2[i][j] = glass[i][j];
					}
				}
			}

//			for(int[] i : glass2) {
//				for(int j:i) {
//					System.out.print(j);
//				}
//				System.out.println();
//			}
//			System.out.println(search(glass2));

			if (search(glass2)) {
				ans = Math.min(size, ans);
			}

			return;
		}

		//for (int i = 0; i < size; i++) {

//			result[i] = list.get(i);
			checkA[list.get(idx)] = true;
			change(idx + 1, size, list);

			checkA[list.get(idx)] = false;
			change(idx + 1, size, list);
		//}

	}

	static boolean search(int[][] arr) {
//		System.out.println(Arrays.deepToString(arr));
		int result = 0;
		for (int j = 0; j < W; j++) {
			int cntA = 0;
			int cntB = 0;
//			System.out.println("j:"+j);
			boolean flag = false; //완성이 됐는지를 췌크하는 용도다
			for (int i = 0; i < D; i++) {
//				System.out.println(cntA+" "+cntB);
				if (arr[i][j] == 0) {
					cntB = 0;
					cntA++;
					if (cntA == K) {
						result++;
						flag = true;
						break;
					}
					
//					if(j==W-1) return false;
				} else if (arr[i][j] == 1) {
					cntA = 0;
					cntB++;
					if (cntB == K) {
						result++;
						flag = true;
						break;
					}
					
//					if(j==W-1) return false;
				}
			}
			if(flag == false) return false;
//			System.out.println(result);
		}

		if (result == W)
			return true;
		else
			return false;
	}


}