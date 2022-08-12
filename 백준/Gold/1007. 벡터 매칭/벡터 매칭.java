import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<int[]> arrayList = new ArrayList<>();
	static double min = 100000000000.0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[] arr= new int[N];
			int[] result = new int[N];
			boolean[] isVisited = new boolean[N];
			for(int i=0; i<N; i++) {
				arr[i] = i;
			}
			for(int i=0; i<N; i++) {
				int[] xandy = new int[2];
				xandy[0]= sc.nextInt();
				xandy[1]= sc.nextInt();
				
				arrayList.add(xandy);
			}
			
			combination(arr,isVisited,0,N/2);
			System.out.println(min);
			
			arrayList.clear();
			min = 100000000000.0;
		}
	}
	
	
	static void combination(int[] arr, boolean[] isVisited, int start, int r) {
		if(r == 0) {
			int vectorsumx = 0,vectorsumy =0;
			for(int i=0; i<isVisited.length; i++) {
				if(isVisited[i]) {
					vectorsumx += arrayList.get(i)[0];
					vectorsumy += arrayList.get(i)[1];
				}
				else {
					vectorsumx -= arrayList.get(i)[0];
					vectorsumy -= arrayList.get(i)[1];
				}
			}
			double pmin = Math.sqrt(Math.pow(vectorsumx,2)+Math.pow(vectorsumy, 2));
			if(pmin<min) min = pmin;
			
		}else {
			for(int i=start; i<arr.length; i++) {
				if(!isVisited[i]) {
					isVisited[i] = true;
					
					combination(arr,isVisited,i+1,r-1);
					isVisited[i] = false;
					
				}
			}
		}
	}

}