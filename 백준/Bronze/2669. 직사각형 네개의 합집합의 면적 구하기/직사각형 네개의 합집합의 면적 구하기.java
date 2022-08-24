import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] paper = new int[101][101];

		int step = 4;
		while (step > 0) {

			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int i=y1; i<y2; i++) {
				for(int j=x1; j<x2; j++) {
					paper[i][j] = 1;
				}
			}

			step--;
		}
		
		int cnt = 0;
		for(int i=0; i<paper.length; i++) {
			for(int j=0; j<paper.length; j++) {
				if(paper[i][j]==1) cnt++;
			}
		}

		System.out.println(cnt);
	}
}