import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //재료의 개수
		int[] sLevel = new int[N]; //재료의 신맛
		int[] bLevel = new int[N]; //재료의 쓴맛
		
		for(int i=0; i<N; i++) {
			sLevel[i] = sc.nextInt();
			bLevel[i] = sc.nextInt();
		} //신맛 쓴맛 채우기
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<(1<<N); i++) { //재료 N개로 만들 수 있는 부분집합의 개수로 재료를 반드시 넣어야 하기 때문에 무조건 존재해야 함
			int sMultiple = 1; //신맛의 곱
			int bSum = 0; //쓴맛의 합
			
			for(int j=0; j<N; j++) { //원소 탐색
				
				if( (i & (1<<j)) > 0) { //부분집합 i에 j번쨰 원소가 들어가면
					
					sMultiple *= sLevel[j]; //신맛은 곱해주고
					bSum += bLevel[j]; //쓴맛은 더해줘요
					
				}
			}
			
			min = Math.min(min, Math.abs(sMultiple-bSum)); //신맛과 쓴맛의 차이와 기존 최소값을 비교해서 갱신
		}
		
		System.out.println(min);
		
	}

}