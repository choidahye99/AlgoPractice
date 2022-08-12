import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
		int N = sc.nextInt(); // 회문 단어 길이

		char[][] alp = new char[8][8];

		for (int i = 0; i < 8; i++) {
			String abc = sc.next();
			for (int j = 0; j < 8; j++) {
				alp[i][j] = abc.charAt(j);
			}
		}

		int record = 0; // 회문일 경우 기록

		int i = 0;
		int j = 0;

		//가로 탐색
		while (i < 8) {
			if (N % 2 == 0) { // 짝수
				int mid = N / 2 - 1 ; // 가운데 단어 인덱스 (짝수라서 만약 4글자라면 인덱스 1,즉 두번째 글자를 중간값으로 설정)
				int test = 0; //회문 맞는지 아닌지 검사용 변수
				for (int k = 0; k < N/2; k++) { // 가운데 단어에서 양쪽으로 얼만큼 비교할지 조절하는 for문
					if (Character.compare(alp[i][mid +j - k], alp[i][mid + 1 + j + k]) == 0) { //왼쪽 오른쪽 검사
						test++; // 왼쪽 오른쪽이 동일하면 검사용 변수 +1
					} 
					if (test == N / 2) { // 회문이면 대칭이 N/2번 나타나니까 N/2와 검사용 변수가 같으면
						record++; //회문 추가
						test=0; // 검사용 변수 다시 쓰기 위해 초기화
					}
				}
				j++; // 행 한칸 옮기자~
				if(mid+j>7-(N/2)) { // 행의 끝까지 가면 
					i++; // 줄 바뀌면서
					j=0; // j 초기화
				}
			} else if(N%2==1) {
				int mid = N / 2 ; // 가운데 단어 인덱스
				int test = 0;
				for (int k = 0; k < N/2; k++) {
					if (Character.compare(alp[i][mid -1 +j - k], alp[i][mid + 1 + j + k]) == 0) {
						test++;
					} 
					if (test == N / 2) {
						record++;
						test=0;
					}
				}
				j++;
				if(mid+j>7-(N/2)) {
					i++;
					j=0;
				}
			}
		}
		
		i = 0; //while문이라 위의 i값이 그대로 담겨있으므로 초기화 해줘야 함. 안 해주면 i가 8부터 시작이라 인덱스 에러 나요~
		
		//세로탐색
		while (j < 8) {
			if (N % 2 == 0) { // 짝수
				int mid = N / 2 - 1 ; // 가운데 단어 인덱스
				int test = 0;
				for (int k = 0; k < N/2; k++) {
					if (Character.compare(alp[mid +i - k][j], alp[mid + 1 + i + k][j]) == 0) {
						test++;
					} 
					if (test == N / 2) {
						record++;
						test=0;
					}
				}
				i++;
				if(mid+i>7-(N/2)) {
					j++;
					i=0;
				}
			} else if(N%2==1) {
				int mid = N / 2 ; // 가운데 단어 인덱스
				int test = 0;
				for (int k = 0; k < N/2; k++) {
					if (Character.compare(alp[mid -1 +i - k][j], alp[mid + 1 + i + k][j]) == 0) {
						test++;
					} 
					if (test == N / 2) {
						record++;
						test=0;
					}
				}
				i++;
				if(mid+i>7-(N/2)) {
					j++;
					i=0;
				}
			}
		}

		System.out.println("#"+tc+" "+record);

		} // 테스트케이스 반복

	}// main

}