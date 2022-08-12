import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int aArr[] = new int[N];
		int bArr[] = new int[N];
		
		for(int i = 0; i<N; i++) {
			aArr[i] = sc.nextInt();
			bArr[i] = aArr[i];
		}
		
		Arrays.sort(bArr);
		
		
		int pArr[] = new int[N];
		boolean[] isVisited = new boolean[N];
		for(int i=0; i<N; i++) {
			int idx = 0;
			for(int j=0; j<N; j++) {
				if(aArr[j] == bArr[i] && !isVisited[j]) {
					idx = j;
					isVisited[j] = true;
					break;
				}
			}
			pArr[idx] = i;
			
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(pArr[i]+" ");
		}

	}

}