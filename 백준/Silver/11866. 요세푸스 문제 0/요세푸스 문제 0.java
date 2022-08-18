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
		int K = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		sb.append('<');
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		int num = 1;
		while(!q.isEmpty()) {
			if(num != K) {
				q.add(q.poll());
				num++;
			}else {
				sb.append(q.poll()).append(", ");
				num = 1;
			}
			
		}
		
		sb.setLength(sb.length()-2);
		sb.append('>');
		System.out.println(sb);
		
		
	}

}
