
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer> dp = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] indexArr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		dp.add(arr[0]);
		for(int i=0; i<N; i++) {
			
			indexArr[i] = binarySearch(arr[i]);
//			binarySearch(arr[i]);
			
		}
//		System.out.println(Arrays.toString(indexArr));
		sb.append(dp.size()).append("\n");
		int num = dp.size();
		int[] resultArr = new int[dp.size()];
		for(int i=N-1; i>=0; i--) {
			if(indexArr[i] == num) {
				resultArr[num-1] = arr[i];
				num--;
			}
		}
		
		for(int i=0; i<dp.size(); i++) {
			sb.append(resultArr[i]).append(" ");
		}
		System.out.println(sb);
		
		
//		sb.append(dp.size()).append("\n");
//		int[] resultArr = new int[dp.size()];
//		for(int i= N-1,idx = dp.size()-1; i>=0; i--) {
//			if(idx == dp.size()-1 && arr[i]>=dp.get(idx)) {
//				resultArr[idx] = arr[i];
//				idx--;
//			}else if(arr[i]>=dp.get(idx) && arr[i]<resultArr[idx+1]) {
//				resultArr[idx] = arr[i];
//				idx--;
//			}
//			if(idx == -1) break; 
//		}
//		
//		for(int i=0; i<resultArr.length; i++) {
//			sb.append(resultArr[i]).append(" ");
//		}
//		System.out.println(sb);
		
	}
	
	static int binarySearch(int key) {
		int start = 0;
		int end = dp.size()-1;
		
		while(start<=end) {
			int mid = (start+end)/2;
			if(dp.get(mid) ==key) {
				return mid+1;
				
			}
			else if(dp.get(mid) >key) end = mid-1;
			else start = mid+1;
			
			if(start>=dp.size()) {
				dp.add(key);
				return dp.size();
			}
			if(start>end) {
				dp.set(start, key);
				return start+1;
			}
			
		}
		// 이건 왜필요할까
		return 0;
		
		
	}

}
