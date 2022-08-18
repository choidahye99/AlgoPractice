import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		
		int N = sc.nextInt();
		int K = 2;
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		int num = 1;
		while(q.size() >1) {
			if(num != K) {
				q.poll();
				num++;
			}else {
				q.add(q.poll());
				num = 1;
			}
			
		}
		
		
		
		System.out.println(q.poll());
		
		
	}

}