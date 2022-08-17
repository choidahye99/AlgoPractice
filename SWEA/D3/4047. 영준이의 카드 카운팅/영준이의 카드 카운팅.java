import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			String card = sc.next();
			// 영준이가 전체 가지고 있는 카드 수는 입력받은문자열길이/3
			// 왜냐면 카드 한 장 당 세글자씩 끊어서 읽으니까
			char[][] cardArr = new char[card.length() / 3][3];

			int k = 0; // card로 받은 문자열을 나눠야 되는데 i, j로 컨트롤 할 수 없으니까 밖에서 관리
			for (int i = 0; i < card.length() / 3; i++) {
				for (int j = 0; j < 3; j++) {
					cardArr[i][j] = card.charAt(k++);
				}
			}

			//ERROR 관리 
			int z = 0; //기준이 되는 값이 들어있는 배열 인덱스
			int w = 1; //비교할 값이 들어있는 배열 인덱스
			String ment = null; //에러 표시
			while (z < card.length() / 3-1) { //비교는 마지막 값 할 필요 없으므로 전체에서 -1만큼
					if(cardArr[z][0]==cardArr[w][0]&&cardArr[z][1]==cardArr[w][1]&&cardArr[z][2]==cardArr[w][2]) { //완전히 동일한 카드라면
						ment = "ERROR"; //멘트는 에러로 바뀐다
					}
					w++; //동일한 요소가 없으면 다음 배열로 이동
					if(w>=card.length() / 3) { //w가 인덱스이기 때문에 겉배열 크기 "이상이면" 에러남 ㅠㅠㅠ!! 이거 간과하지 맙시다......
						z++; // 한바퀴 다 돌았으니까 다음 기준으로 넘김
						w = z+1; //비교값 초기화
					}
			}

			if (ment != null) { //위에서 동일한 값이 나왔다면 멘트에 ERROR가 담겨있다
				System.out.println("#" + tc + " " + ment);
			} else {
				// S D H C 순서
				int[] check = new int[4]; // 몇 개 가지고 있는지
				int[] need = { 13, 13, 13, 13 }; // 필요한 카드 수

				for (int i = 0; i < card.length() / 3; i++) { // 카드가 몇개 필요한지 알아봅시당
					switch (cardArr[i][0]) {
					case 'S':
						need[0] = need[0] - 1; //이미 가지고 있단 얘기이므로 필요한 카드 -1
						continue;
					case 'D':
						need[1] = need[1] - 1;
						continue;
					case 'H':
						need[2] = need[2] - 1;
						continue;
					case 'C':
						need[3] = need[3] - 1;
						continue;
					}

				}

				//출력
				System.out.print("#"+tc+" ");
				for(int i:need)
					System.out.print(i+" ");
				System.out.println();

			}
		}
	}

}
