
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
		StringBuilder sb = new StringBuilder();
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
				if(q.isEmpty()) sb.append(-1).append('\n');
				else sb.append(q.peek()).append('\n');
				break;
			case "back":
				if(q.isEmpty()) sb.append(-1).append('\n');
				else sb.append(lastout).append('\n');
				break;
			case "size":
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				if(q.isEmpty()) sb.append(1).append('\n');
				else sb.append(0).append('\n');
				break;
			case "pop":
				if(q.isEmpty()) sb.append(-1).append('\n');
				else sb.append(q.poll()).append('\n');
				break;
			default:
				break;
				
			}
		}
		System.out.println(sb);
	}

}
