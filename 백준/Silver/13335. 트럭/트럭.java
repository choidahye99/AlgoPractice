import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N= sc.nextInt();
		int W = sc.nextInt();
		int L = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> timeq = new LinkedList<>();
		Queue<Integer> weightq = new LinkedList<>();
		for(int i=0; i<N; i++) {
			q.add(sc.nextInt());
		}
		
		int T = 0;
		int weight=0;
		int idx=0;
		while(!q.isEmpty() || !weightq.isEmpty()) {
			T++;
			
			if(!timeq.isEmpty() && timeq.peek()==T) {
				weight -= weightq.peek();
				weightq.poll();
				timeq.poll();
			}
			if(!q.isEmpty() && q.peek()+weight <= L) {
				weight += q.peek();
				weightq.add(q.peek());
				q.poll();
				timeq.add(T+W);
				
			}
			
			
		}
		System.out.println(T);
		
		
	}

}