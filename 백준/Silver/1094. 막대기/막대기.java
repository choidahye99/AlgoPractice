import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt(); //만들어야 하는 막대의 길이
		
		//64를 만들 수 있는 모든 부분집합
		for(int i=0; i<(1<<7); i++) {
			int sum = 0;
			int cnt = 0;
			//원소 판단
			for(int j=0; j<=6; j++) {
				if( (i & (1<<j))>0) { //i에 원소 j가 포함되어 있으면
					sum += (1<<j);
					cnt++;
				}
			}
			
			if(sum==X) {
				System.out.println(cnt);
				break;
			}
		}
		
		
	}

}
