
import java.util.Scanner;

public class Main {
	static String arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		 arr = new String[N][2];
		
		for(int i=0; i<N; i++) {
			String v = sc.next(),l=sc.next(),r=sc.next();
			arr[v.charAt(0)-65][0] = l;
			arr[v.charAt(0)-65][1] = r;
			
		}
		
		pt("A");
		System.out.println();
		it("A");
		System.out.println();
		pot("A");
		
	}
	
	static void pt(String node) {
		
		System.out.print(node);
		
		if(arr[node.charAt(0)-65][0].charAt(0)>=65 && arr[node.charAt(0)-65][0].charAt(0) <=90) {
			pt(arr[node.charAt(0)-65][0]);
		}
		if(arr[node.charAt(0)-65][1].charAt(0)>=65 && arr[node.charAt(0)-65][1].charAt(0) <=90) {
			pt(arr[node.charAt(0)-65][1]);
		}
		
	}
	static void it(String node) {
		
		
		
		if(arr[node.charAt(0)-65][0].charAt(0)>=65 && arr[node.charAt(0)-65][0].charAt(0) <=90) {
			it(arr[node.charAt(0)-65][0]);
		}
		System.out.print(node);
		if(arr[node.charAt(0)-65][1].charAt(0)>=65 && arr[node.charAt(0)-65][1].charAt(0) <=90) {
			it(arr[node.charAt(0)-65][1]);
		}
		
	}

	static void pot(String node) {
	
	
	
	if(arr[node.charAt(0)-65][0].charAt(0)>=65 && arr[node.charAt(0)-65][0].charAt(0) <=90) {
		pot(arr[node.charAt(0)-65][0]);
	}
	
	if(arr[node.charAt(0)-65][1].charAt(0)>=65 && arr[node.charAt(0)-65][1].charAt(0) <=90) {
		pot(arr[node.charAt(0)-65][1]);
	}
	System.out.print(node);
	
}

}
