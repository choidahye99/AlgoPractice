import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arrow = new int[1000002]; //1부터 N까지 쓸거애용
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			int H = sc.nextInt();
			
			if(arrow[H+1] == 0) { //나보다 위에 이미 쏜 화살이 없으면
				arrow[H]++; //여기서부터 쏘고 있는 화살 있다고 표시
				cnt++;
			} else { //이미 위에서 쏴지고 있는 화살이 있어~~
				arrow[H+1]--; //위에 화살 사용해서 여기 풍선 없앴웅
				 arrow[H]++; //여기서부터 화살 다시 출발
			}
		}
		
		System.out.println(cnt);
		
		
	}

}