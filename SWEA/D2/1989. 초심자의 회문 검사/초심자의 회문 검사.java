import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			String word = sc.next(); // 단어 받기

			char[] test = word.toCharArray(); // 단어 요소 배열에 넣기

			int len = test.length; // 단어 길이

			int result = 0; // 회문인 경우 1을 반환

			if (len % 2 == 1) { // 단어의 길이가 홀수인 단어
				int mid = len / 2 ; // 가운데 단어 인덱스
				for (int i = 1; i <= len / 2; i++) { // 단어 길이만큼 탐색해봅시다
					if (Character.compare(test[mid - i], test[mid + i])==0) {
						result = 1; // 회문인 경우
					} else {
						result = 0;
						break; //탐색 멈춤
					}
				}
			} else if (len % 2 == 0) {
				int mid = len/2;
				for (int i = 1; i <= len / 2; i++) { // 단어 길이만큼 탐색해봅시다
					if (Character.compare(test[mid-i] , test[mid + i -1])==0) {
						result = 1; // 회문인 경우
					} else {
						result = 0;
						break; //탐색 멈춤
					}
				}
			}

			System.out.println("#"+tc+" "+result);
		}
	}

}
