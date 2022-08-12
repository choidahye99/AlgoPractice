import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int target = sc.nextInt();
		
		int[] arr= new int[N];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		
		}
		
		int max = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				for(int k = j+1; k<arr.length; k++) {
					int testnum = arr[i]+arr[j]+arr[k];
					if(testnum>max && testnum<=target) {
						max = testnum;
					}
				}
			}
		}
		
		System.out.println(max);
	}

}