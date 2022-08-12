import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		int max = 0;
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 최대 몇개인지 계산
		for(int i=0; i<N; i++) {
			int count = 0;
			double gr = -1000000001.0; 
			double gl = 1000000001.0;
			for(int j=i+1; j<N; j++) {
				double incline = (arr[j]-arr[i])/((double)j-(double)i);
				if(gr < incline) {
					count ++;
					gr = incline;
				}
			}
			
			for(int j = i-1; j>=0; j--) {
				double incline = (arr[j]-arr[i])/((double)j-(double)i);
				if(gl > incline) {
					count ++;
					gl = incline;
				}
			}
			
			if(count>max) max = count;
		}
		
		
		System.out.println(max);
	}
}