import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 문서개수
			int targetidx = sc.nextInt(); // 관심있는 문서
			Queue<Integer> q = new LinkedList<Integer>();
			int[] count = new int[10];
			int targetNumber = 0;
			// count 넣고 queue 에 넣고 
			for(int i=0; i<N; i++) {
				int num = sc.nextInt();
				q.add(num);
				count[num]++;
				if(i == targetidx) targetNumber = num; 
			}
			
			int result = 1;
			int currCount = 9;
			while(!q.isEmpty()) {
				if(count[currCount] == 0) {
					currCount--;
					continue;
				}
				
				if(q.peek() == currCount) {
					q.poll();
					if(targetidx == 0) break;
					result++;
					count[currCount]--;
				}else {
					q.add(q.poll());
				}
				
				if(targetidx == 0) targetidx = q.size()-1;
				else targetidx--;
				
			}
			
			System.out.println(result);
		}
	}

}