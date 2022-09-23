import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = sc.nextInt(); //연산의 개수
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			
			int num = sc.nextInt();
			
			if(num!=0) {
				pq.add(-num);
			} else {
				if(pq.isEmpty()) sb.append(0).append("\n");
				else sb.append(-pq.poll()).append("\n");
				
			}
			
			
		}
		
		System.out.println(sb);
		
	}

}