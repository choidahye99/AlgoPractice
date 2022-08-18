import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>(); 
		
		
		int lastout = 0;
		for(int i=0 ; i<N; i++) {
			String command = br.readLine();
			st = new StringTokenizer(command," ");
			switch(st.nextToken()) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				q.add(num);
				lastout = num; 
				break;
			case "front":
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peek());
				break;
			case "back":
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(lastout);
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				if(q.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "pop":
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.poll());
				break;
			default:
				break;
				
			}
		}
	}

}
