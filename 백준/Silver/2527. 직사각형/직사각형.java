import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		for (int t = 0; t < 4; t++) {
			int j1 = sc.nextInt();
			int i1 = sc.nextInt();
			int j2 = sc.nextInt();
			int i2 = sc.nextInt();

			int j3 = sc.nextInt();
			int i3 = sc.nextInt();
			int j4 = sc.nextInt();
			int i4 = sc.nextInt();
			
			//겹치지 않을 경우
			if(j2<j3||j4<j1||i2<i3||i4<i1) System.out.println("d");
			
			//점
			else if((j2==j3&&i2==i3)||(j1==j4&&i2==i3) ||(j2==j3&&i1==i4)||(j1==j4&&i1==i4)) System.out.println("c");
			
			//선분
			else if(j3==j2||j4==j1||i2==i3||i1==i4) System.out.println("b");
			
			//나머지 다 직사각형
			else System.out.println("a");
		}

	}
}