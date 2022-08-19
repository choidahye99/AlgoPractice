import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<>();

		for (int tc = 1; tc <= 10; tc++) {

			int N = sc.nextInt(); // 원래 암호문의 길이

			for (int i = 0; i < N; i++) {
				int num = sc.nextInt();
				list.add(num);
			} // 리스트에 원래 암호 추가하기

			int cmdCnt = sc.nextInt(); // 명령어 개수

			for (int i = 0; i < cmdCnt; i++) {
				String cmd = sc.next(); // I D A

				// I 삽입
				if (cmd.equals("I")) {
					int idx = sc.nextInt(); // 몇번째부터 끼어들건지
					int Y = sc.nextInt(); // 몇개의 숫자를 끼울건가용
					for (int j = 0; j < Y; j++) {
						int secretCode = sc.nextInt(); // 끼어들 암호
						list.add(idx + j, secretCode); // 끼어보아요
				}
			} else if (cmd.equals("D")) { //D 삭제
				int idx = sc.nextInt(); //몇번째부터 삭제할건지
				int Y = sc.nextInt(); //몇개를 지울건가용
				for(int j=0; j<Y; j++) {
					list.remove(idx+j);
				}
			} else if(cmd.equals("A")) { //A 추가
				int Y = sc.nextInt(); //몇개의 숫자를 덧붙일래
				for(int j=0; j<Y; j++) {
					int secretCode = sc.nextInt();
					list.addLast(secretCode);
				}
			}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();

			list.clear();

		} // Test
	}// Main
}