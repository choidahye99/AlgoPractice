import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //1부터 몇까지 받을 건지
		
		String[] nums = new String[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = String.valueOf(i+1);
		}
		
		for(int i=0; i<N; i++) {
			int cnt=0;
			for(int j=0; j<nums[i].length(); j++) {
				char x = nums[i].charAt(j);
				
				switch(x) {
				case'3':
				case'6':
				case'9':
					cnt++;
				}
			}
			if(cnt>0) {
			String ans = "";
			for(int k=0; k<cnt; k++) {
				ans += "-";
			}
			nums[i] = ans;
			}
		}
		
		for(String i : nums)
		System.out.print(i+" ");
	}
}