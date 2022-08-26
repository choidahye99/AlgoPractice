import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); //테스트케이스

		for (int tc = 1; tc <= T; tc++) {
			String str1 = sc.next(); //첫번째 알파벳들
			int[] num1 = new int[str1.length()]; //첫번째 문장을 뜯어 담을 배열
			change(num1, str1); //구멍이 몇개인지 따져 뜯어봅시다

			String str2 = sc.next(); //두번째 알파벳들
			int[] num2 = new int[str2.length()]; //두번째 문장을 뜯어 담을 배열
			change(num2, str2); //구멍이 몇개인지 따져 뜯어봅시다

			if (str1.length() != str2.length()) { //두 문장의 길이가 다르면
				System.out.println("#" + tc + " " + "DIFF"); //바로 다르다 띄우기
			} else {
				int cnt = 0; //몇개가 똑같은지 세어봅시다
				for(int i=0; i<str1.length(); i++) {
					if(num1[i]==num2[i]) cnt++; //같으면 cnt추가
				}
				
				if(cnt==str1.length()) { //문장의 길이와 똑같은 문자의 길이가 같으면
					System.out.println("#"+tc+" "+"SAME"); //같다고 띄워주세요
				} else System.out.println("#" + tc + " " + "DIFF"); //아니면 달라요~

			}
		}

	}

	public static void change(int[] num, String str) {

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i); //문장하나하나 뜯어서

			switch (ch) {
			case 'B': //구멍이 두 개면
				num[i] = 2; //2로 표시
				break;
			case 'A': //구멍이 한 개면
			case 'D':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
				num[i] = 1; //1로 표시
				break;
			default:
				num[i] = 0; //아니면 기본은 0
			}
		}
	}
}