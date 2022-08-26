import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트케이스
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt(); //입력받을 숫자 크기
			int[] num = new int[N]; //숫자 입력
			
			for(int i=0; i<N; i++) {
				num[i] = sc.nextInt();
			}
			
			int max = 0;
			
			int i=0;
			int j = i+1;

			while(i<N-1) {
				String mNum = String.valueOf(num[i]*num[j]);
				
				int cnt=0;
				for(int k=0; k<mNum.length()-1; k++) {
					char ch = mNum.charAt(k);
					char ch2 = mNum.charAt(k+1);
					if(ch-'0'<=ch2-'0') {
						cnt++;
					} else break;
				}
				
				if(cnt==mNum.length()-1) max=Math.max(max, Integer.parseInt(mNum));
				
				j++;
				if(j>N-1) {
					i++;
					j = i+1;
				}
			}
			
			if(max==0) max = -1;
			
			System.out.println("#"+tc+" "+max);
			
			
			
		}//testCase
	} //main

}
