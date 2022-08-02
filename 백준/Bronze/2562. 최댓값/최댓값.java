import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		
		for(int i:arr) {
			max = Math.max(max, i);
		}
		
		int cnt=1;
		
		for(int i=0; i<9; i++) {
			if(arr[i]!=max) {
				cnt++;
			} else break;
		}
		System.out.println(max);
		System.out.println(cnt);
	}

}
