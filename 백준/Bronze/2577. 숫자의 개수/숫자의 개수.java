import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int m = A*B*C;
		
		String num = String.valueOf(m);
		
		int len = num.length();
		
		char[] arr = num.toCharArray();
		int[] arr2 = new int[len];
		
		int ken=0;
		for(char i:arr) {
			arr2[ken++]=Character.getNumericValue(i);
		}
		
		int[] nums = new int[10];
		
		for(int i=0; i<len; i++) {
			nums[arr2[i]] += 1;
		}
		
		for(int i=0; i<10; i++) {
			System.out.println(nums[i]);
		}
	}

}