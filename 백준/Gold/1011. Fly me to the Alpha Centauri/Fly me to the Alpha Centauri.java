import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		for(int t=0; t<T; t++) {
			String line = sc.nextLine();
			long dis = Long.parseLong(line.split(" ")[1])-Long.parseLong(line.split(" ")[0]);
			
			min2(dis);
			
		}
		
		
	}
	
 
	static void min2(long d) {
		long right = 10000000L;
		long left = 0L;
		long mid = (right+left)/2;
		long sum = 0L;
		
		while(true) {
			mid = (right+left)/2;
			
			if(mid%2 == 0) {
				sum = (mid/2)*(mid/2+1);
				
			}else {
				sum = ((mid+1)/2)*((mid+1)/2+1)-(mid+1)/2;
			}
			
			if(mid == left) {
				System.out.println(mid+1);
				break;
			}else if(d == sum) {
				System.out.println(mid);
				break;
			}else if(d<sum) {
				right = mid;
				
			}else {
				left = mid;
				
			}
		}
		
		
		
	}

}