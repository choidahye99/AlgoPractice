import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//가로와 세로를 1부터 하나씩 늘려가면서 곱하되, 넓이가 n이하라고 제시되어 있으므로 범위 안에 있도록 제한
		//a*b와 b*a는 같은 것으로 취급하기 때문에 이중 포문을 돌릴 때 j<=i라는 조건을 줄 것
		
		int n = sc.nextInt();
		
		int squareCnt = 0; //직사각형 몇개 만들 수 있는지??
		for(int i=1; i<n+1; i++) { //가로 길이 
			for(int j=1; j<=i; j++) {
				if(i*j<=n) squareCnt++;
			}
		}
		
		System.out.println(squareCnt);
	}

}