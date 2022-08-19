
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int W = sc.nextInt();
		int H = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int P = sc.nextInt();
		
		int arr[][] = new int[P][2];
		
		for(int i=0; i<P; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		int result = 0;
		for(int i=0; i<P; i++) {
			
			// 직사각형 
			if(arr[i][0]>= X && arr[i][0] <= X+W && arr[i][1] >= Y && arr[i][1] <= Y+H) {
				result += 1;
				continue;
			}
			
			if(Math.pow(arr[i][0]-X, 2)+Math.pow(arr[i][1]-Y-H/2, 2) <= Math.pow(H/2, 2)) {
				result+= 1;
				continue;
			}
			
			if(Math.pow(arr[i][0]-X-W, 2)+Math.pow(arr[i][1]-Y-H/2, 2) <= Math.pow(H/2, 2)) {
				result+= 1;
				continue;
			}
			
		}
		
		System.out.println(result);
	}
}
