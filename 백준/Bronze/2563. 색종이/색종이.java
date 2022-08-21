import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] paper = new int[100][100];
		
		int cnt = sc.nextInt(); ///색종이 장수
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				paper[i][j] = 0;
			}
		}
		
		int k=0;
		while(k<cnt) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int i=x; i<x+10; i++) {
				for(int j=y; j<y+10; j++) {
					paper[i][j] = 1;
				}
			}
			k++;
		}
		
		int area = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(paper[i][j]==1) {
					area++;
				}
			}
		}
		
		System.out.println(area);
	}
}