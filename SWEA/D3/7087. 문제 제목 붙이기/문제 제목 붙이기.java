import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] point;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //단어 개수
			point = new int[N]; //맨 앞 첫글자
			for(int i=0; i<N; i++) {
				point[i] = sc.next().charAt(0) - 'A';
			}
			
			
			for(int i=0; i<N-1; i++) {
				int j = i+1;
				while(j<N) {
					if(point[i]==point[j]) {
						point[j] = 49;
					}
					j++;
				}
			}
			
			Arrays.sort(point);
			
			check(point);
			
			int cnt =0;
			for(int i=0; i<N; i++) {
				if(point[i]>=0&&point[i]<26) {
					cnt++;
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
			
		}
	}
	
	static void check(int[] point) {
		
		if(point[0]!=0) {
			for(int i=0; i<N; i++) {
				point[i] = -1;
			}
			return;
		} else {
			for(int i=0; i<N-1; i++) {
				if(point[i+1]==point[i]+1) {
					continue;
				} else {
					for(int j=i+1; j<N; j++) {
						point[j] = -1;
					}
				}
			}
		}
	}
}