import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int tc=0; tc<T; tc++) {
			int k = sc.nextInt(); //층수
			int n = sc.nextInt(); //호수
			
			int[][]arr = new int[k+1][n];
			

				for(int j =0; j<n; j++) {
					arr[0][j] = j+1;
				}
			
			for(int i=1; i<k+1; i++) {
				arr[i][0] = 1;
			}
			
			for(int i=1; i<k+1; i++) {
				for(int j=1; j<n; j++) {
					arr[i][j]=arr[i-1][j]+arr[i][j-1];
				}
			}
			
			System.out.println(arr[k][n-1]);
			
		}
	}

}