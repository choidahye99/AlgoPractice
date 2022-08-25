import java.util.Scanner;

public class Main {
	static int[][] board;
	static int[] nums;
	static int cnt; // 숫자 몇개 썼는지

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 5*5
		// 빙고판을 입력받아용
		// 숫자를 입력받습니다 그리고 카운트 세기
		// 15까지는 함수 안 받아도 됨
		// 숫자 15개 이상이 지워졌다? 행탐색 열탐색 대각선탐색 해보아요
		// 빙고가 3개 이상이면 숫자 몇 개 받았는지 출력하기~

		board = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = sc.nextInt();
			}
		} // 빙고판에 숫자 채우기

		nums = new int[25];
		for (int i = 0; i < 25; i++) {
			nums[i] = sc.nextInt();
		}

		for (int k = 0; k < 25; k++) {

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (nums[k] == board[i][j]) {
						board[i][j] = 0;
						cnt++;
					}

				}
			}

			if (bingo()) {
				System.out.println(cnt);
				return;
			}
		}
	}

	private static boolean bingo() {
		int bingo = 0;
		// 행탐색
		for(int i=0; i<5; i++) {
			int zero = 0;
			for(int j=0; j<5; j++) {
				if(board[i][j] == 0) zero++;
			}
			if(zero==5) bingo++;
		}
		// 열탐색
		for(int i=0; i<5; i++) {
			int zero = 0;
			for(int j=0; j<5; j++) {
				if(board[j][i] == 0) zero++;
			}
			if(zero==5) bingo++;
		}
		// 대각선탐색
		int zero1 = 0;
		int zero2 = 0;
		for(int i=0; i<5; i++) {
			if(board[i][i]==0) zero1++;
			if(board[i][4-i]==0) zero2++;
		}
		
		if(zero1==5) bingo++;
		if(zero2==5) bingo++;
		// bingo가 3이면 true 반환
		
		if(bingo>=3) return true;
		return false;
	}

}
