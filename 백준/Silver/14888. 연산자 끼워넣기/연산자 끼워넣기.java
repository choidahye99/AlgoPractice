
import java.util.Arrays;
import java.util.Scanner;
	
	

public class Main {
	static int[] arrstatic;
	static int max = -1000000000;
	static int min = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		arrstatic = new int[num];
		for(int i=0; i<num; i++) {
			arrstatic[i] = sc.nextInt();
		}
		int[] operatorArr = new int[num-1]; 
		boolean[] isVisited = new boolean[num-1];
		int[] result = new int[num-1];
		int count =0;
		int operNum = 0;
		int i=0;
		while(i<num-1) {
			if(count == 0) {
				count = sc.nextInt();
				operNum++;
			}
			
			if(count !=0) {
				operatorArr[i] = operNum;
				count--;
				i++;
				
			}
			
		}
		
		permutation(operatorArr, isVisited,result,num-1);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void permutation(int[] arr, boolean[] isVisited, int[] result, int r) {
		if(r == 0) {
			int sum = arrstatic[0];
			for(int i=0; i<result.length; i++) {
				if(result[i] == 1) {
					sum += arrstatic[i+1];
				}else if(result[i] == 2) {
					sum -= arrstatic[i+1];
				}else if(result[i] == 3) {
					sum *= arrstatic[i+1];
				}else {
					if((sum>=0 && arrstatic[i+1]>0) || (sum<0 && arrstatic[i+1]<0)  ) {
						sum = Math.abs(sum)/Math.abs(arrstatic[i+1]);
					}else sum= -(Math.abs(sum)/Math.abs(arrstatic[i+1]));
				}
			}
			if(max<sum) max = sum;
			if(min>sum) min = sum;
			
		}else {
			for(int i=0; i<arr.length; i++) {
				if(!isVisited[i]) {
					isVisited[i] = true;
					result[result.length-r] = arr[i];
					permutation(arr,isVisited,result,r-1);
					isVisited[i] = false;
					result[result.length-r] = 0;
				}
			}
		}
	}
}
