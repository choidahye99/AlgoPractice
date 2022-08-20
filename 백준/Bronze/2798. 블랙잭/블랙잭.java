import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cardAmt = sc.nextInt(); // 카드 개수
		int M = sc.nextInt(); // 딜러가 외친 숫자
		int[] cardArr = new int[cardAmt];

		for (int i = 0; i < cardAmt; i++) {
			cardArr[i] = sc.nextInt();
		} // 가지고 있는 카드


		int result = 0; //결과값
		
		for (int i = 0; i < cardAmt - 2; i++) { // 마지막 두 장은 의미X
			for (int j = i + 1; j < cardAmt - 1; j++) {
				for (int k = j + 1; k < cardAmt; k++) {
					
					int add = cardArr[i] + cardArr[j] + cardArr[k]; // 카드 세 개 더한 총합 모두 구하기
					
					if(add == M) {
						System.out.println(add);
						return;
					} 
					
					if(result < add && add<M) {
						result = add;
					}
				}

			}

		}
		
		System.out.println(result);

	}

}