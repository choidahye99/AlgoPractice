
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stMN = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(stMN.nextToken());
		int M = Integer.parseInt(stMN.nextToken());
		char[][] bw = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				bw[i][j] = str.charAt(j);
			}
		}
		
		
		int sum1[][] = new int[N-7][M-7]; // wbwbwb..
		int sum2[][] = new int[N-7][M-7]; // bwbwbw...
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if((i+j)%2 == 0) {
					if(bw[i][j] == 'B') sum1[0][0]++;
					else sum2[0][0]++;
				}
				else {
					if(bw[i][j] == 'W') sum1[0][0]++;
					else sum2[0][0]++;
				}
			}
		}
		
		for(int i=0; i<N-7; i++) {
			
			if(i !=0) {
				sum1[i][0] = sum1[i-1][0];
				sum2[i][0] = sum2[i-1][0];
				for(int k=0; k<8; k++) {
					if((k+i-1) % 2 == 0) {
						if(bw[i-1][k] == 'B') sum1[i][0]--;
						else sum2[i][0]--;
					}else {
						if(bw[i-1][k] == 'W') sum1[i][0]--;
						else sum2[i][0]--;
					}
					
					if((k+i-1) % 2 == 0) {
						if(bw[i+7][k] == 'B') sum1[i][0]++;
						else sum2[i][0]++;
					}else {
						if(bw[i+7][k] == 'W') sum1[i][0]++;
						else sum2[i][0]++;
					}
				}
			}
			
			
			for(int j=1; j<M-7; j++) {
				sum1[i][j] = sum1[i][j-1];
				sum2[i][j] = sum2[i][j-1];
				for(int k = i; k<i+8; k++) {
					if((k+j-1)%2 == 0) {
						if(bw[k][j-1] == 'B') sum1[i][j]--;
						else sum2[i][j]--;
					}else {
						if(bw[k][j-1] == 'W') sum1[i][j]--;
						else sum2[i][j]--;
					}
					
					if((k+j-1)%2 == 0) {
						if(bw[k][j+7] == 'B') sum1[i][j]++;
						else sum2[i][j]++;
					}else {
						if(bw[k][j+7] == 'W') sum1[i][j]++;
						else sum2[i][j]++;
					}
					
				}
			}
		}
		
//		System.out.println(Arrays.deepToString(sum1));
//		System.out.println(Arrays.deepToString(sum2));
//		
		int min = 100;
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
				if(sum1[i][j]<min) min = sum1[i][j];
				if(sum2[i][j]<min) min = sum2[i][j];
			}
		}
		System.out.println(min);
	}

}
