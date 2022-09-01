import java.util.Arrays;
import java.util.Scanner;


//이분탐색 

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		} //가지고 있는 숫자카드
		
		Arrays.sort(arr); //이분 탐색을 하기 위해서는 반드시 정렬되어 있어야 함
		
		int M = sc.nextInt();
		
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0; i<M; i++) {
			int key = sc.nextInt(); //상근이가 가지고 있는 숫자 카드 개수를 셀 기준이 될 숫자
			
			//upperBound와 lowerBound의 차이값을 구한다
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' '); //중복값의 제일 나중 인덱스 - 중복값 인덱스의 제일 처음 인덱스 => 중복값이 몇 개인지 개수
		}
		
		System.out.println(sb);
		
		
		
	}
	
	private static int lowerBound(int[] arr, int key) {
		int start = 0;
		int end = arr.length;
		
		//start가 end를 넘어가기 전까지 반복
		while(start < end) {
			int mid = (start+end)/2; //중간 위치를 구한다
			
			//key값이 중간값의 위치보다 작거나 같을 경우 중복값에 대해 왼쪽으로 탐색하게 end를 내린다
			if(key<=arr[mid]) {
				end = mid;
			} else { //그게 아니면 start 값을 mid 다음으로
				start = mid+1;
			}
		}
		
		return end;
	}
	
	private static int upperBound(int[] arr, int key) {
		int start = 0;
		int end = arr.length;
		
		//start가 end를 넘어가기 전까지 반복
		while(start < end) {
			int mid = (start+end)/2; //중간 위치의 경우
			
			//key 값이 중간 위치의 값보다 작을 경우
			if(key < arr[mid]) {
				end = mid;
			} 
			//중복원소의 경우 else에서 처리
			else {
				start = mid+1;
			}
		}
		
		return start;
	}

}