import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 숫자 개수

			int[] num = new int[N];

			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}

			// 버블정렬
			/*
			 * for (int i = 0; i < N - 1; i++) { //마지막 건 확인 안 해도 for (int j = N - 2 - i; j
			 * >= 0; j--) { //j+1이랑 비교하기 위해 마지막인덱스를 N-2로 설정 if (num[j] > num[j + 1]) {
			 * //비교해서 뒤 숫자가 더 크면 int temp = num[j + 1]; //앞 숫자 임시로 담고 num[j + 1] = num[j];
			 * //뒤에 있는 숫자 앞으로 인덱스 바꿔주고 num[j] = temp; //작은 숫자는 뒤로 보내기 } } }
			 * 
			 * System.out.print("#" + tc + " "); for (int i : num) {
			 * System.out.print(i+" "); } System.out.println(); }
			 */
			
			//선택정렬
			System.out.print("#"+tc+" ");
			SelectionSort(num, N);
			System.out.println();
		} // TestCase
	}// main

	public static void SelectionSort(int[] num, int N) {

		for(int i=0; i<N-1; i++) {
			int min_idx = i;
			
			for(int j=i+1; j<N; j++) {
				if(num[j]<num[min_idx]) {
					min_idx = j;
				}
			}
			
			int temp = num[i];
			num[i] = num[min_idx];
			num[min_idx] = temp;
			
		}
		for(int i:num)
		System.out.print(i+" ");
	}
	

}
