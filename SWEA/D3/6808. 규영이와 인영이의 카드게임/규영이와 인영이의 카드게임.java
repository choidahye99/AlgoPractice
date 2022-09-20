
import java.util.Scanner;

public class Solution {
	static int[] arr; //인영이 카드
	static int[] kArr; //규영이 카드
	static int[] result; //인영이가 가진 카드를 섞어서 만든 배열
	static boolean[] check; //인영이가 가진 카드 썼는지 안썼는지 체크하는 배열
	static int win; //인영이랑 규영이가 대결 했을 때 규영이가 최종적으로 이기면 ++
	static int lose; //인영이랑 규영이가 대결했을 때 규영이가 최종적으로 지면 ++

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {
			
			//인영이가 가진 숫자, 규영이가 가진 숫자 배열 초기화
			arr = new int[9];
			kArr = new int[9];

			for (int i = 0; i < 9; i++) {
				kArr[i] = sc.nextInt();
			} //규영이 배열 채우고용

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				int cnt = 0;
				for (int j = 0; j < 9; j++) {
					if (kArr[j] != i) cnt++;
				}
				
				if(cnt==9) arr[idx++] = i;
			} //남은 카드 인영이한테 주기
			
			
			//인영이 카드 섞기 전에 이전 결과 배열 초기화
			result = new int[9];
			check = new boolean[9];
			
			//섞인 인영이 카드로 대결하기 전에 이전 승부 결과 초기화
			win = 0;
			lose = 0;
			
			Permutation(0); //순열
			
			System.out.println("#"+tc+" "+win+" "+lose);
			
		} // 테스트케이스

	} // main

	private static void Permutation(int idx) {
		
		//탈출문
		if(idx == 9) { //결과 배열 인덱스가 9가 되면 이미 다 채워졌단 뜻
			
			int kWin = 0; //규영이가 이겼을 때 얻은 카드 총합
			int yWin = 0; //인영이가 이겼을 때 얻은 카드 총합
			
			for(int i=0; i<9; i++) {
				if(kArr[i] > result[i]) { //규영이가 이기면
					kWin += kArr[i] + result[i]; //규영이 총합에 규영이 카드 값+인영이 카드 값
				} else if (kArr[i] < result[i]) { //인영이가 이기면
					yWin += result[i] + kArr[i]; //인영이 총합에 규영이 카드 값+인영이 카드 값
				}
			}
			
			//대결이 끝나고...
			if(kWin > yWin) win++; //카드 값 총합이 규영이가 더 크면 win++
			else if(kWin < yWin) lose++; //인영이가 더 크면 lose++
						
			return;
		}
		
		//가지를 만들어줍니다
		for(int i=0; i<9; i++) {
			if(!check[i]) { //인영이가 가진 카드 중에 안 쓴 카드가 있으면
				
				check[i] = true; //쓰고
				result[idx] = arr[i]; //규영이와 대결할 인영이 배열에 카드 추가				
				Permutation(idx+1); // 다음으로 넘어가여
				
				check[i] = false; //카드를 다른 순서에 또 쓸 거니까
			}
		}
		
	}

}
