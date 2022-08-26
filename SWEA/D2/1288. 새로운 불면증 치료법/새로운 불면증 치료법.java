import java.util.Scanner;

public class Solution {
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 양 시작 숫자
			num = new int[10]; // 숫자 체크 배열
			int add = 1; //배수 조절 변수

			while (true) { //답 나올때까지 반복문 돌려봅시다
				int nAdd = N * add; //배수
				String sN = String.valueOf(nAdd); //뜯어봐야하니까 String으로 바꿔요~

				for (int i = 0; i < sN.length(); i++) {
					num[sN.charAt(i) - '0']++; //숫자로 변환해서 인덱스로 씁시다
				}

				if (check()) { //true면
					System.out.println("#"+tc+" "+sN); //정답 출력하고
					break; //while문 종료
				}
				add++; //아니면 배수 증가
			}
		} //테스트케이스
	} //main

	static public boolean check() { //0~9까지 다 사용했는지 체크해봅시다
		int cnt = 0; //숫자 몇개 안 썼는지
		for (int i = 0; i < 10; i++) {
			if (num[i] == 0) //안쓴 숫자가 있으면
				cnt++; //cnt 추가
		}

		if (cnt == 0) //안 쓴 숫자가 없으면
			return true; //true 반환
		return false;
	}

}