

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt(); //가지고 있는 랜선 개수
		int N = sc.nextInt(); //필요한 랜선 개수
		int[] lineLen = new int[K]; //가지고 있는 랜선의 길이 배열 
		
		
		//시작할 땐 가지고 있는 제일 긴 막대의 길이를 자를 막대라고 보겠어요
		
		long max = 0; //자를 막대 길이의 기준이 될 초기값(=가지고 있는 막대 중 제일 긴 막대)를 구해봅시다
		
		//배열에 길이를 담아주면서 max 갱신
		for(int i=0; i<K; i++) {
			lineLen[i] = sc.nextInt();
			
			if(lineLen[i] > max) { //입력받은 길이가 더 길다면
				max = lineLen[i]; //max값 갱신
			}
		}
		
		//자연수 탐색 범위가 0~max+1이어야 하므로 조절해줍시다
		max = max+1;
		
		long min = 0; //자를 막대 길이의 최소값. 처음이니까 0부터 시작하겠죠
		long standard = 0; //가지고 있는 랜선을 나눌 막대 길이 기준
		
		while(min < max) {
			
			standard = (max+min)/2; // 범위 내 중간 길이로 기준을 잡아봅시다
			
			long cnt = 0; //나누고 나서 막대가 총 몇개인지
			
			for(int i=0; i<K; i++) { //가지고 있는 랜선을 잘라봅시다
				cnt += lineLen[i]/standard; //가지고 있는 랜선을 standard 기준으로 잘랐을 때 얻을 수 있는 막대 수를 cnt에 더해줍니다
			}
			
			if(cnt < N) { //지금 standard 길이로 자르면 나오는 막대 수가 필요한 막대보다 모자라네요
				//더 짧게 잘라봅니다
				max = standard;
			} else { //필요한 막대수보다 많이 구했네요. 
				// 더 길게 잘라도 될 것 같으니 좀 더 길게 잘라봅시다
				min = standard+1;
			}
		}
		
		System.out.println(min-1); //자를 막대 길이의 최소값-1 = N개의 랜선을 가질 때 제일 긴 막대의 길이
	} //main
}
