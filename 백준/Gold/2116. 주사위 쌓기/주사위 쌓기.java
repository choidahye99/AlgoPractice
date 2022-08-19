import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[][] = new int[N][6];
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<6; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<6; i++) {
			int sum = 0;
			int idx = i;
			int first = -1;
			int end = -1;
			for(int j=0; j<N; j++) {
				
				if(idx == 0) {
					first = arr[j][0];
					end = arr[j][5];
					sum += Math.min(first, end) == 5 ? 4 : (Math.max(first, end) == 6 ? 5 : 6); 
					
					for(int k=0; j!=N-1 && k<6; k++) {
						if(arr[j+1][k] == end) {
							idx = k;
						}
					}
					
				}else if(idx == 1) {
					first = arr[j][1];
					end = arr[j][3];
					sum += Math.min(first, end) == 5 ? 4 : (Math.max(first, end) == 6 ? 5 : 6); 
					for(int k=0; j!=N-1 && k<6; k++) {
						if(arr[j+1][k] == end) {
							idx = k;
						}
					}
				}else if(idx == 2) {
					first = arr[j][2];
					end = arr[j][4];
					sum += Math.min(first, end) == 5 ? 4 : (Math.max(first, end) == 6 ? 5 : 6); 
					for(int k=0; j!=N-1 && k<6; k++) {
						if(arr[j+1][k] == end) {
							idx = k;
						}
					}
				}else if(idx == 3) {
					first = arr[j][3];
					end = arr[j][1];
					sum += Math.min(first, end) == 5 ? 4 : (Math.max(first, end) == 6 ? 5 : 6); 
					for(int k=0; j!=N-1 && k<6; k++) {
						if(arr[j+1][k] == end) {
							idx = k;
						}
					}
				}else if(idx == 4) {
					first = arr[j][4];
					end = arr[j][2];
					sum += Math.min(first, end) == 5 ? 4 : (Math.max(first, end) == 6 ? 5 : 6); 
					for(int k=0; j!=N-1 && k<6; k++) {
						if(arr[j+1][k] == end) {
							idx = k;
						}
					}
				}else {
					first = arr[j][5];
					end = arr[j][0];
					sum += Math.min(first, end) == 5 ? 4 : (Math.max(first, end) == 6 ? 5 : 6); 
					for(int k=0; j!=N-1 && k<6; k++) {
						if(arr[j+1][k] == end) {
							idx = k;
						}
					}
				}
				
				
			}
			
			if(max<sum) max = sum;
		}
		System.out.println(max);
	}

}