import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//전체 회의수
		int N = sc.nextInt();
		
		int[][] timeTable = new int[N][2];
		
		for(int i=0; i<N; i++) {
			timeTable[i][0] = sc.nextInt(); //시작시간 입력
			timeTable[i][1] = sc.nextInt(); //마무리시간 입력
		}
		

		//2차원 배열이므로 comparator 사용 (참고: https://seeminglyjs.tistory.com/164)
		Arrays.sort(timeTable, new Comparator<int[]>() {
			//@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) { //첫번째 숫자 기준 오름차순: 종료시간이 같을 경우 시작시간 오름차순 정렬
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1]; //두번째 숫자 기준 오름차순: 회의 종료 시간 기준 오름차순 정렬
			}
		});
		
		int cnt = 0; // 회의 개수
		int end = 0; // 마지막 시간을 기록해야 함 (초기화 할 값)
		
		for(int i=0; i<N; i++) {
			if(timeTable[i][0]>=end) {
				end = timeTable[i][1]; // 마지막 시간 갱신
				cnt++; // 회의 개수 추가
			}
		}
		
		System.out.println(cnt);
	}

}