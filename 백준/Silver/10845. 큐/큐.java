import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		//Queue 선언
		Queue<Integer> que = new LinkedList<>();
		
		int last = 0;
		
		for(int i=0; i<N; i++) { //명령어 개수만큼 돕니다
			
			String commend = sc.next(); //명령어
			int r = 0;
			if(commend.equals("push")) {
				int num = sc.nextInt();
				r=num;
			}
			
			switch(commend) {
			case "push":
				last = r;
				que.offer(last);
				break;
				
			case "pop" :
				if(que.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(String.valueOf(que.poll())).append("\n");
				}
				break;
			case "size":
				sb.append(que.size()).append("\n");
				break;
			case "empty":
				if(que.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front":
				if(que.isEmpty()) sb.append(-1).append("\n");
				else sb.append(que.peek()).append("\n");
				break;
			case "back":
				if(que.isEmpty()) sb.append(-1).append("\n");
				else sb.append(last).append("\n");
				break;
			}
			
		}
		
		System.out.println(sb);
		
	}

}