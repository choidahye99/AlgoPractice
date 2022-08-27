import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt(); // 연산 갯수
			
			PriorityQueue<Integer> heap = new PriorityQueue<>();
			
			sb.append("#").append(tc);
			
			for(int i =  0 ; i<N ;i++) {
				int op = sc.nextInt();
				if(op == 1) {
					int num = sc.nextInt();
					//최소힙이 기본이라 최대힙처럼 쓰려고 음수로 바꿈...
					heap.add(-num);
				}else {
					if(heap.isEmpty())
						sb.append(" -1");
					else
						sb.append(" ").append(-heap.poll());
				}
			}
			System.out.println(sb.toString());
		}//tc
	}//main
}