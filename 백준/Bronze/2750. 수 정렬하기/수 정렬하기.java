import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] arr2 = Arrays.copyOfRange(mergeSort(arr), 0, arr.length);
		for(int i=0; i<N; i++) {
			System.out.println(arr2[i]);
		}
	}
	
static int[] mergeSort(int[] arr) {
		
		if(arr.length == 1) {
			return arr;
		}
		int[] arr1 = mergeSort(Arrays.copyOf(arr, arr.length/2));
		int[] arr2 = mergeSort(Arrays.copyOfRange(arr,arr.length/2 , arr.length));
		return merge(arr1,arr2);		
			
	}
	static int[] merge(int[] arr1, int[] arr2) {
		int[] mergedArr = new int[arr1.length+arr2.length];
		
		int i=0,i1=0,i2=0;
		while(i<arr1.length+arr2.length) {
			if(i1 == arr1.length) {
				mergedArr[i] = arr2[i2];
				i2++;
			}else if(i2 == arr2.length) {
				mergedArr[i] = arr1[i1];
				i1++;
			}else if(arr1[i1] <arr2[i2]) {
				mergedArr[i] = arr1[i1];
				i1++;
			}else {
				mergedArr[i] = arr2[i2];
				i2++;
			}
			
			i++;
		}
		return mergedArr;
	}

}