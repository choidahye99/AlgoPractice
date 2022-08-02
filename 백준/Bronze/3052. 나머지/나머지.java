import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[1000];
		
		for(int i=0; i<10; i++) {
			int A = sc.nextInt();
			int a = A%42;
			nums[a] +=1;
		}
		
		int cnt =0;
		for(int i=0; i<1000; i++) {
			if(nums[i]!=0) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}