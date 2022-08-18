import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int M = sc.nextInt();
		for(int i=0; i<M; i++) {
			int num = sc.nextInt();
			boolean hasNum = false;
			int start = 0;
			int end = arr.length-1;
			int key = num;
			while(start<=end) {
				int mid = (start+end)/2;
				if(arr[mid] ==key) {
					hasNum = true;
					
					break;
				}
				else if(arr[mid]>key) end = mid-1;
				else start = mid+1;
				
				
				
				
			}
			if(hasNum) System.out.println(1);
			else System.out.println(0);
		}
	}

}
