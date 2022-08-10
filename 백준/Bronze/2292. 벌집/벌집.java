import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//범위를 다뤄보자 1 / 2~7 / 8~13 ...
		
		//가야 할 방 (범위안에 들어갈 수)
		int N = sc.nextInt();
		
		int cnt = 1; //첫번째방부터 시작하는데 시작방도 카운트하니까 1이 처음값
		int range = 2; //범위 (최솟값기준)
		
		if(N==1) {
			System.out.println(1);
		} else {
			while(range <= N) { // 범위를 벗어나면 false
				range = range + (6*cnt); //범위간 차이가 6이니까 그거에 맞춰서 최소값 갱신
				cnt++;
			}
			System.out.println(cnt); //어느 범위에 있는지만 알아내면 되기 때문에 cnt 출력
		}
		
	}

}
