import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //카드 게임 횟수
		
		for(int tc=0; tc<T; tc++){
			int cntA = sc.nextInt(); //카드에 있는 문양 개수
			int[] arrA = new int[cntA];
			
			for(int i=0; i<cntA; i++) {
				arrA[i] = sc.nextInt();
			}
			
			int cntB = sc.nextInt();
			int[] arrB = new int[cntB];
			
			for(int i=0; i<cntB; i++) {
				arrB[i] = sc.nextInt();
			} //카드 입력 받음
			
			int starA = 0;
			int circleA = 0;
			int squareA = 0;
			int triangleA = 0;
			
			for(int i=0; i<cntA; i++) {
				switch(arrA[i]) {
				case 4: 
					starA++;
					break;
				case 3:
					circleA++;
					break;
				case 2:
					squareA++;
					break;
				case 1:
					triangleA++;
					break;
				}
			}
			
			int starB = 0;
			int circleB = 0;
			int squareB = 0;
			int triangleB = 0;
			
			for(int i=0; i<cntB; i++) {
				switch(arrB[i]) {
				case 4: 
					starB++;
					break;
				case 3:
					circleB++;
					break;
				case 2:
					squareB++;
					break;
				case 1:
					triangleB++;
					break;
				}
			}
			
			if(starA == starB) {
				if(circleA == circleB) {
					if(squareA == squareB) {
						if(triangleA == triangleB) {
							System.out.println("D");
						} else {
							if(triangleA > triangleB) {
								System.out.println("A");
							} else {
								System.out.println("B");
							}
						}
					} else {
						if(squareA > squareB) {
							System.out.println("A");
						} else {
							System.out.println("B");
						}
					}
					
				} else {
					if(circleA > circleB) {
						System.out.println("A");
					} else {
						System.out.println("B");
					}
				}
				
			} else {
				if(starA>starB) {
					System.out.println("A");
				} else {
					System.out.println("B");
				}
			}
			
		}
	}
}